package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
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
    var hideUi by rememberSaveable { mutableStateOf(false) }

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

    if (!hideUi) {
        MainTextNormal(text = "You are now level: $level \nWhat do you wanna do today?")

        MiniPokemonBall()
    }

    BoxWithConstraints {
        hideUi = maxWidth > 500.dp
    }
}
