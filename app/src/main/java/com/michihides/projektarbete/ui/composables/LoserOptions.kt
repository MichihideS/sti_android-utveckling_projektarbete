package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.destinations.ChoosePokemonScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.screens.LoggedInScreen
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate

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
            modifier = Modifier
                .padding(bottom = 50.dp)
        )

        MainMenuButton(buttonText = "Go back to Main") {
            navigator.navigate(LoggedInScreenDestination(
                username,
                password,
                level
            ))
        }
    }
}