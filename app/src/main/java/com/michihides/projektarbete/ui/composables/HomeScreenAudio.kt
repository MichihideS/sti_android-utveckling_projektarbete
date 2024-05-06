package com.michihides.projektarbete.ui.composables

import android.media.MediaPlayer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.michihides.projektarbete.R

// Plays a music file on the HomeScreen and releases as soon as you click
@Composable
fun HomeScreenAudio() {
    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    val sound by remember {
        mutableStateOf(MediaPlayer.create(context, R.raw.controls_wishes))
    }

    sound.start()

    // Releases the sound when switching composable
    DisposableEffect(Unit) {
        onDispose {
            sound.release()
        }
    }
}