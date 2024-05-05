package com.michihides.projektarbete.ui.composables

import android.content.Context
import android.media.MediaPlayer
import com.michihides.projektarbete.R

fun MainButtonSound(context: Context) {
    val sound = MediaPlayer.create(context, R.raw.menu_button)
    sound.start()
}