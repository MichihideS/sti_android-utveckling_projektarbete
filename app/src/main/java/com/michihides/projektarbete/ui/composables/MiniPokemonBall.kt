package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R
import com.michihides.projektarbete.ui.theme.GeneralBackground

@Composable
fun MiniPokemonBall() {
    var hideUi by rememberSaveable { mutableStateOf(false) }

    if (!hideUi) {
        Image(
            painter = painterResource(id = R.drawable.pokemon_ball),
            contentDescription = "",
            modifier = Modifier
                .padding(horizontal = 130.dp)
        )
    }

    BoxWithConstraints {
        if (maxWidth > 500.dp) {
            hideUi = true
            Image(
                painter = painterResource(id = R.drawable.pokemon_ball),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 420.dp)
            )
        } else {
            hideUi = false
        }
    }
}