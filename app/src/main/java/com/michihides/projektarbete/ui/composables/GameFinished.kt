package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
fun GameFinished(
    navigator: DestinationsNavigator
)  {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(BlackTransparent)
    ) {
        Text(
            text = "Sorry you are too good!\nThere are no more battles here!",
            fontSize = 72.sp,
            modifier = Modifier
                .padding(bottom = 50.dp)
        )

        MainMenuButton(buttonText = "Back to Home") {
            navigator.navigate(HomeScreenDestination)
        }
    }
}