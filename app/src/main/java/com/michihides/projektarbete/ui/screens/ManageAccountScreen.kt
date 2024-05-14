package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.ChangePasswordScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ManageAccountScreen(
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

    // Sets the user with the username, password and level through navigation
    val user by rememberSaveable {
        mutableStateOf(
            User(username, password, level)
        )
    }

    // Identifies the user from the database with the username
    val userDatabase = db.child("").child(user.username)

    /* An Alertdialog that will show itself if set to true which happens when you press
    ** the Delete Account Button
    */
    val showDeleteAccount = remember {
        mutableStateOf(false)
    }

    // If showDeleteAccount.value is true it will show an alert dialog
    if(showDeleteAccount.value) {
        AlertDialog(
            onDismissRequest = { showDeleteAccount.value = false },
            title = { Text(text = stringResource(id = R.string.delete_account))},
            text = { Text(
                text = stringResource(id = R.string.delete_account_sure),
                fontSize = 16.sp
            )},
            shape = RoundedCornerShape(5.dp),
            containerColor = Color.White,
            confirmButton = {
                Button(
                    onClick = {
                        showDeleteAccount.value = false

                        /* Reads a snapshot from the database and if confirm button is clicked
                        ** will delete the user from the database and return the user to HomeScreen
                        */
                        userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                            override fun onDataChange(snapshot: DataSnapshot) {
                                userDatabase.removeValue(user)
                                navigator.navigate(HomeScreenDestination)
                            }

                            override fun onCancelled(error: DatabaseError) {
                            }
                        })
                              },
                    colors = ButtonDefaults.buttonColors(Color.Blue),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = stringResource(id = R.string.yes))
                }
            }
        )
    }

    MainMenuButtonColumn {
        MainMenuButton(buttonText = stringResource(id = R.string.change_password)) {
            navigator.navigate(ChangePasswordScreenDestination(
                username,
                password,
                level
            ))
        }

        // Pops up the alert dialog
        MainMenuButton(buttonText = stringResource(id = R.string.delete_account)) {
            showDeleteAccount.value = true
        }

        MainMenuButton(buttonText = stringResource(id = R.string.back)) {
            navigator.navigate(LoggedInScreenDestination(
                username,
                password,
                level
            ))
        }
    }
    
    TitleTextNormal(title = stringResource(id = R.string.manage_account_title))

    if (!hideUi) {
        MainTextNormal(text = stringResource(id = R.string.manage_account_text))
    }

    BoxWithConstraints {
        hideUi = maxWidth > 500.dp
    }
}