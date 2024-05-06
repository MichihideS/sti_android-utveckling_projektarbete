package com.michihides.projektarbete.ui.screens

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.destinations.ChoosePokemonScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.ManageAccountScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LoggedInScreen(
    username: String,
    password: String,
    level: Int,
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Play") {
            navigator.navigate(
                ChoosePokemonScreenDestination(
                    username,
                    password,
                    level
                )
            )
        }

        MainMenuButton(buttonText = "Manage Account") {
            navigator.navigate(ManageAccountScreenDestination(
                username,
                password,
                level
            ))
        }

        MainMenuButton(buttonText = "Logout") {
            navigator.navigate(HomeScreenDestination)
        }
    }
}
