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
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
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
fun LoginScreen(
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
    val toastEmptyField = Toast.makeText(context, stringResource(id = R.string.please_username), Toast.LENGTH_SHORT)
    val toastWrong = Toast.makeText(context, stringResource(id = R.string.wrong_username_password), Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, stringResource(id = R.string.error_try_again), Toast.LENGTH_SHORT)

    // Initializing the user
    var user by rememberSaveable {
        mutableStateOf(
            User("", "", 1)
        )
    }

    // Identifies the user from the database with the username
    val userDatabase = db.child("").child(user.username)

    /* Reads a snapshot from the database and checks if the username matches the username input
    ** field. After, it reads again to see if the password field matches the database snapshot and
    ** if that matches too it gets the level value as well to see what level the user was on before.
    ** And after that, navigates with all the parameters
    */
    MainMenuButtonColumn {
        MainMenuButton(buttonText = stringResource(id = R.string.login)) {
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

        MainMenuButton(buttonText = stringResource(id = R.string.back)) {
            navigator.navigate(PlayGameScreenDestination)
        }
    }

    TitleTextNormal(
        title = stringResource(id = R.string.login)
    )

    if (!hideUi) {
        MainTextNormal(
            text = stringResource(id = R.string.login_long)
        )
    }

    BoxWithConstraints {
        hideUi = maxWidth > 500.dp
    }

    UserHandler(
        user = user,
        onChangeUser = { user = it }
    )
}