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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.michihides.projektarbete.destinations.ChoosePokemonScreenDestination
import com.michihides.projektarbete.destinations.HomeScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.models.User
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.michihides.projektarbete.ui.theme.WhiteTransparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

// Gets called if the enemyHealth goes to 0 or below before your health
@Composable
fun WinnerOptions(
    username: String,
    password: String,
    level: Int,
    navigator: DestinationsNavigator
) {
    // Firebase
    val db = FirebaseDatabase
        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
        .getReference("users")

    // Sets the user with the username, password and level through navigation
    var user = User(username, password, level)

    // Identifies the user from the database with the username
    val userDatabase = db.child("").child(user.username)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(WhiteTransparent)
    ) {
        Text(
            text = "You Win!",
            fontSize = 72.sp,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .border(5.dp, Color.Black)
                .background(BlackTransparent)
                .padding(24.dp)
        )

        /* Navigates to the next level and saves the level by +1 to the current user
        ** If the user already is level above 3 it will take you back to the LoggedInScreen
         */
        MainMenuButton(buttonText = "Go to Next Level") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    user.level += 1
                    userDatabase.setValue(user)

                    if (user.level <= 3) {
                        navigator.navigate(
                            ChoosePokemonScreenDestination(
                                username,
                                password,
                                user.level
                            )
                        )
                    } else {
                        navigator.navigate(LoggedInScreenDestination(
                            username,
                            password,
                            user.level,
                        ))
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }

        // Navigates to the HomeScreen and saves the level by +1 to the current user
        MainMenuButton(buttonText = "Save and Exit") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    user.level += 1
                    userDatabase.setValue(user)
                    navigator.navigate(HomeScreenDestination)
                }

                override fun onCancelled(error: DatabaseError) {
                    println("Error")
                }
            })
        }
    }
}