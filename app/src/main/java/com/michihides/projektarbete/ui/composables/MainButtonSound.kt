package com.michihides.projektarbete.ui.composables

import android.content.Context
import android.media.MediaPlayer
import com.michihides.projektarbete.R

// Main sound for the button pressing
fun mainButtonSound(context: Context) {
    val sound = MediaPlayer.create(context, R.raw.menu_button)
    sound.start()
}