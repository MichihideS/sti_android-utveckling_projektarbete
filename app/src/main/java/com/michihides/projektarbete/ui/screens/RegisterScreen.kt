package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.michihides.projektarbete.ui.composables.UserHandler
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun RegisterScreen(
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
    val toastUserCreated = Toast.makeText(context, stringResource(id = R.string.user_created), Toast.LENGTH_SHORT)
    val toastUserExists = Toast.makeText(context, stringResource(id = R.string.user_exists), Toast.LENGTH_SHORT)
    val toastEmptyField = Toast.makeText(context, stringResource(id = R.string.please_username), Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, stringResource(id = R.string.error_try_again), Toast.LENGTH_SHORT)

    // Initializing the user
    var user by rememberSaveable {
        mutableStateOf(
            User("", "", 1)
        )
    }

    // Identifies the user from the database with the username
    val userDatabase = db.child("").child(user.username)

    MainMenuButtonColumn {

        /* Reads a snapshot from the database and if the user field isn't empty or doesn't
        ** exist it will register the newly entered user
        */
        MainMenuButton(buttonText = stringResource(id = R.string.register)) {
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

        MainMenuButton(buttonText = stringResource(id = R.string.back)) {
            navigator.navigate(PlayGameScreenDestination)
        }
    }

    TitleTextNormal(
        title = stringResource(id = R.string.register)
    )

    MainTextNormal(
        text = stringResource(id = R.string.register_long)
    )

    UserHandler(
        user = user,
        onChangeUser = { user = it }
    )
}

