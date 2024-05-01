package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
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
import com.michihides.projektarbete.destinations.LoginScreenDestination
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.UserHandler
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RegisterScreen(
    navigator: DestinationsNavigator
) {
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")

    val context = LocalContext.current

    // Toasts, should use context for Composable function
    val toastUserCreated = Toast.makeText(context, "User Created", Toast.LENGTH_SHORT)
    val toastUserExists = Toast.makeText(context, "User Already Exists", Toast.LENGTH_SHORT)
    val toastEmptyField = Toast.makeText(context, "Please Enter a Username", Toast.LENGTH_SHORT)
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

        // Listener
        MainMenuButton(buttonText = "Register") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (user.username == "") {
                        toastEmptyField.show()
                    } else if (snapshot.exists()) {
                        toastUserExists.show()
                    } else {
                        userDatabase.setValue(user)
                        toastUserCreated.show()
                        navigator.navigate(PlayGameScreenDestination)
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

