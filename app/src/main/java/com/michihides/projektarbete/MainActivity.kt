package com.michihides.projektarbete

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.michihides.projektarbete.destinations.AboutScreenDestination
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.MainMenuButtonColumn
import com.michihides.projektarbete.ui.theme.ProjektarbeteTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {

    // Database initialization
    private lateinit var db : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProjektarbeteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Destinations
                    DestinationsNavHost(
                        navGraph = NavGraphs.root
                    )

                    // Firebase
                    db = FirebaseDatabase
                        .getInstance("https://projektarbete-au-default-rtdb.europe-west1.firebasedatabase.app/")
                        .getReference("users")
                }
            }
        }
    }
}

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator
) {
    MainMenuButtonColumn {
        MainMenuButton(buttonText = "Play Game") {
            navigator.navigate(PlayGameScreenDestination)
        }

        MainMenuButton(buttonText = "About") {
            navigator.navigate(AboutScreenDestination)
        }
    }
}