package com.michihides.projektarbete.ui.screens

import android.widget.Toast
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
import com.michihides.projektarbete.destinations.ManageAccountScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.ChangePassword
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ChangePasswordScreen(
    username: String,
    password: String,
    level: Int,
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
    val toastPasswordUpdate = Toast.makeText(context, "Password Updated", Toast.LENGTH_SHORT)
    val toastEmptyField = Toast.makeText(context, "Please Enter a Password", Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, "Error, try again!", Toast.LENGTH_SHORT)

    // Sets the user with the username, password and level through navigation
    var user by rememberSaveable {
        mutableStateOf(
            User(username, password, level)
        )
    }

    // Identifies the user from the database with the username
    val userDatabase = db.child("").child(user.username)

    /* Reads a snapshot from the database and updates it's value with the input
    ** as long as the field isn't empty
     */
    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Change Password") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (user.password == "") {
                        toastEmptyField.show()
                    } else {
                        userDatabase.setValue(user)
                        toastPasswordUpdate.show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    toastError.show()
                }
            })
        }

        MainMenuButton(buttonText = "Back") {
            navigator.navigate(
                ManageAccountScreenDestination(
                username,
                    // Since Password might get updated here we need to reassign it's value
                password = user.password,
                level
            ))
        }
    }

    ChangePassword(
        user = user,
        onChangeUser = { user = it }
    )
}