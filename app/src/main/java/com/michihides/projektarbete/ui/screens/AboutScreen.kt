package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.composables.MainTextNormal
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
    
    MainTextNormal(text = stringResource(id = R.string.about_text))
    
    Image(
        painter = painterResource(id = R.drawable.element_cicle),
        contentDescription = "",
        modifier = Modifier
            .padding(horizontal = 50.dp)
            .padding(top = 200.dp)
    )
}