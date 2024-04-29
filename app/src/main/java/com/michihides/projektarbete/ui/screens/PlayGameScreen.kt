package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.michihides.projektarbete.destinations.RegisterScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PlayGameScreen(
    navigator: DestinationsNavigator
) {
    Column {
        Button(onClick = { navigator.navigate(RegisterScreenDestination) }) {
            Text(text = "Register")
        }
    }

}