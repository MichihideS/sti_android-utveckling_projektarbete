package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.MainButtonSound
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.UserHandler
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    // Firebase
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")

    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    // Toasts, should use context for Composable function
    val toastEmptyField = Toast.makeText(context, "Please Enter a Username", Toast.LENGTH_SHORT)
    val toastWrong = Toast.makeText(context, "Wrong Username or Password, try again!", Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, "Error, try again!", Toast.LENGTH_SHORT)

    var user by rememberSaveable {
        mutableStateOf(
            User("", "", 1)
        )
    }

    val userDatabase = db.child("").child(user.username)

    UserHandler(
        user = user,
        onChangeUser = { user = it }
    )

    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Login") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (user.username == "") {
                        toastEmptyField.show()
                    } else if (snapshot.exists()) {
                        val databasePassword = snapshot.child("password").getValue(String::class.java)
                            user.level = snapshot.child("level").getValue(Int::class.java)!!
                        if (user.password == databasePassword) {
                            navigator.navigate(LoggedInScreenDestination(
                                username = user.username,
                                password = user.password,
                                level = user.level
                            ))
                        } else {
                            toastWrong.show()
                        }
                    } else {
                        toastWrong.show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    toastError.show()
                }
            })
        }

        MainMenuButton(buttonText = "Back") {
            navigator.navigate(PlayGameScreenDestination)
        }
}
}