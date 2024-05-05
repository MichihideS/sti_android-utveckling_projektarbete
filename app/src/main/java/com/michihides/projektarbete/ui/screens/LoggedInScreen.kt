package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.google.firebase.database.FirebaseDatabase
import com.michihides.projektarbete.destinations.ChoosePokemonScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.LevelOneScreenDestination
import com.michihides.projektarbete.destinations.ManageAccountScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.composables.GameFinished
import com.michihides.projektarbete.ui.composables.MainButtonSound
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
