package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.AboutScreenDestination
import com.michihides.projektarbete.destinations.LoginScreenDestination
import com.michihides.projektarbete.destinations.RegisterScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
import com.michihides.projektarbete.ui.composables.MiniPokemonBall
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PlayGameScreen(
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = stringResource(id = R.string.login)) {
            navigator.navigate(LoginScreenDestination)
        }

        MainMenuButton(buttonText = stringResource(id = R.string.register)) {
            navigator.navigate(RegisterScreenDestination)
        }

        MainMenuButton(buttonText = stringResource(id = R.string.about)) {
            navigator.navigate(AboutScreenDestination)
        }
    }

    TitleTextNormal(
        title = stringResource(id = R.string.welcome_title)
    )

    MainTextNormal(
        text = stringResource(id = R.string.welcome_text)
    )

    MiniPokemonBall()
}