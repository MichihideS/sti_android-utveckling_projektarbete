package com.michihides.projektarbete.ui.composables

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.michihides.projektarbete.ui.viewModels.PokemonEnemyViewModel

@Composable
fun PokemonEnemyDataUI(
    pokemonName: String,
    viewModel: PokemonEnemyViewModel = viewModel()
) {
    val pokemon by viewModel.pokemonUiState
    
    // Trigger fetch on initial composition
    LaunchedEffect(true) {
        viewModel.fetchPokemonData(pokemonName)
    }
    
    if (pokemon != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = pokemon?.species?.name.toString())
            AsyncImage(
                model = pokemon?.sprites?.frontSprite,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(300.dp)
                    .clip(shape = CircleShape)
            )

            // Sound setup for the pokemon cry
            val context = LocalContext.current
            val pokemonSound = Uri.parse(pokemon?.cries?.latest)
            val sound  = MediaPlayer.create(context, pokemonSound)
            sound.start()

        }
    } else {
        Text(text = "Wait patiently...")
    }
}