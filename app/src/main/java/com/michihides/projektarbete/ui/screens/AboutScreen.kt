package com.michihides.projektarbete.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun AboutScreen(
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = stringResource(id = R.string.back)) {
            navigator.navigate(PlayGameScreenDestination)
        }
    }
    
    TitleTextNormal(title = stringResource(id = R.string.about))
}