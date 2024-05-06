package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.michihides.projektarbete.R

@Composable
fun MiniPokemonBall() {
    Image(
        painter = painterResource(id = R.drawable.pokemon_ball),
        contentDescription = "",
        modifier = Modifier
            .padding(horizontal = 130.dp)
    )
}