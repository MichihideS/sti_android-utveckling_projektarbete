package com.michihides.projektarbete.ui.composables

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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.michihides.projektarbete.ui.viewModels.PokemonAllyViewModel

@Composable
fun PokemonChooseTwoDataUI(
    pokemonName: String,
    viewModel: PokemonAllyViewModel = viewModel()
) {
    val pokemon by viewModel.pokemonUiState

    // Trigger fetch on initial composition
    LaunchedEffect(true) {
        viewModel.fetchPokemonData(pokemonName)
    }

    if (pokemon != null) {
        AsyncImage(
            model = pokemon?.sprites?.frontSprite,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(200.dp)
        )
    } else {
        Text(text = "Wait patiently...")
    }
}