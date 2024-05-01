package com.michihides.projektarbete.ui.screens

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.google.firebase.database.FirebaseDatabase
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoginScreen(
    navigator: DestinationsNavigator
) {
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")

    val context = LocalContext.current

    // Toasts, should use context for Composable function
    val toastEmptyField = Toast.makeText(context, "Please Enter a Username", Toast.LENGTH_SHORT)
    val toastError = Toast.makeText(context, "Wrong Username or Password, try again!", Toast.LENGTH_SHORT)

    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Login") {

        }

        MainMenuButton(buttonText = "Back") {
            navigator.navigate(PlayGameScreenDestination)
        }
}
}