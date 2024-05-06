package com.michihides.projektarbete.ui.screens

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AboutScreen(
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Back") {
            navigator.navigate(PlayGameScreenDestination)
        }
    }
}