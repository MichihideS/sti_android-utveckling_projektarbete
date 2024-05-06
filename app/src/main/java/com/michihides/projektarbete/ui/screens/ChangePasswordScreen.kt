package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.ManageAccountScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.ChangePassword
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
import com.michihides.projektarbete.ui.composables.TitleTextNormal
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
    var hideUi by rememberSaveable { mutableStateOf(false) }

    // Firebase
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")

    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    // Toasts, should use context for Composable function
    val toastPasswordUpdate = Toast.makeText(context, stringResource(id = R.string.password_updated), Toast.LENGTH_SHORT)
    val toastEmptyField = Toast.makeText(context, stringResource(id = R.string.enter_password), Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, stringResource(id = R.string.error_try_again), Toast.LENGTH_SHORT)

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
        MainMenuButton(buttonText = stringResource(id = R.string.change_password)) {
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

        MainMenuButton(buttonText = stringResource(id = R.string.back)) {
            navigator.navigate(
                ManageAccountScreenDestination(
                username,
                    // Since Password might get updated here we need to reassign it's value
                password = user.password,
                level
            ))
        }
    }
    
    TitleTextNormal(title = stringResource(id = R.string.change_password))

    if (!hideUi) {
        MainTextNormal(text = stringResource(id = R.string.new_password))
    }

    BoxWithConstraints {
        if (maxWidth > 500.dp) {
            hideUi = true
        } else {
            hideUi = false
        }
    }

    ChangePassword(
        user = user,
        onChangeUser = { user = it }
    )
}