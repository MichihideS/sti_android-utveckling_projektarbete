package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

// Gets called if the health goes to 0 or below before the enemyHealth
@Composable
fun LoserOptions(
    username: String,
    password: String,
    level: Int,
    navigator: DestinationsNavigator
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(BlackTransparent)
    ) {
        Text(
            text = "You Lose!",
            fontSize = 72.sp,
            textAlign = TextAlign.Center,
            color = Color.Red,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .border(5.dp, Color.Black)
                .background(BlackTransparent)
                .padding(24.dp)
        )

        // Navigates to the LoggedInScreen
        MainMenuButton(buttonText = "Go back to Main") {
            navigator.navigate(LoggedInScreenDestination(
                username,
                password,
                level
            ))
        }

        // Navigates to the HomeScreen
        MainMenuButton(buttonText = "Exit Game") {
            navigator.navigate(HomeScreenDestination)
        }
    }
}