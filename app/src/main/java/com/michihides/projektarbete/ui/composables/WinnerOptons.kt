package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.michihides.projektarbete.ui.theme.BlackTransparent
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import com.ramcosta.composedestinations.navigation.navigate

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



    var user = User(username, password, level)

    val userDatabase = db.child("").child(user.username)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(BlackTransparent)
    ) {
        Text(
            text = "You Win!",
            fontSize = 72.sp,
            modifier = Modifier
                .padding(bottom = 50.dp)
        )

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
                }
            })
        }


        MainMenuButton(buttonText = "Save and Exit") {
            userDatabase.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    user.level += 1
                    userDatabase.setValue(user)
                    navigator.navigate(HomeScreenDestination)
                }

                override fun onCancelled(error: DatabaseError) {
                }
            })
        }
    }
}