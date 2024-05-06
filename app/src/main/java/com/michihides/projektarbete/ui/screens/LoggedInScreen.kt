package com.michihides.projektarbete.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.ChoosePokemonScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.ManageAccountScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
import com.michihides.projektarbete.ui.composables.MiniPokemonBall
import com.michihides.projektarbete.ui.composables.TitleTextNormal
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
        MainMenuButton(buttonText = stringResource(id = R.string.play)) {
            navigator.navigate(
                ChoosePokemonScreenDestination(
                    username,
                    password,
                    level
                )
            )
        }

        MainMenuButton(buttonText = stringResource(id = R.string.manage_account)) {
            navigator.navigate(ManageAccountScreenDestination(
                username,
                password,
                level
            ))
        }

        MainMenuButton(buttonText = stringResource(id = R.string.logout)) {
            navigator.navigate(HomeScreenDestination)
        }
    }

    TitleTextNormal(title = "Elite Trainer $username")
    
    MainTextNormal(text = "You are now level: $level \nWhat do you wanna do today?")

    MiniPokemonBall()
}
