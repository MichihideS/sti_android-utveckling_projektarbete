package com.michihides.projektarbete

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.michihides.projektarbete.destinations.PlayGameScreenDestination
import com.michihides.projektarbete.ui.composables.HomeScreenAudio
import com.michihides.projektarbete.ui.composables.HomeScreenColumn
import com.michihides.projektarbete.ui.theme.ProjektarbeteTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class MainActivity : ComponentActivity() {

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

                    /* MUSIC USED FROM
                    ** https://youtu.be/KKhEwcWMH9M?si=FPB0mD9kzBcwkmGR
                    ** https://mixkit.co/free-sound-effects/click/
                    ** https://dl.vgmdownloads.com/soundtracks/pokemon-omega-ruby-and-alpha-sapphire-super-music-complete-nintendo-3ds/jncuuodcoj/6-47%20Battle%21%20%28Steven%29.mp3
                     */
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
    HomeScreenAudio()

    HomeScreenColumn {
        navigator.navigate(PlayGameScreenDestination)
    }
}
