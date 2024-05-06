package com.michihides.projektarbete.ui.screens

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.destinations.AboutScreenDestination
import com.michihides.projektarbete.destinations.LoginScreenDestination
import com.michihides.projektarbete.destinations.RegisterScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PlayGameScreen(
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Login") {
            navigator.navigate(LoginScreenDestination)
        }

        MainMenuButton(buttonText = "Register") {
            navigator.navigate(RegisterScreenDestination)
        }

        MainMenuButton(buttonText = "About") {
            navigator.navigate(AboutScreenDestination)
        }
    }
}