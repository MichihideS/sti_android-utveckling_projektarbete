package com.michihides.projektarbete.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.michihides.projektarbete.ui.viewModels.PokemonAllyViewModel

@Composable
fun PokemonAllyDataUI(
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
           model = pokemon?.sprites?.backSprite,
           contentDescription = null,
           contentScale = ContentScale.Crop,
           modifier = Modifier
               .size(300.dp)
       )
    } else {
        Text(text = "Wait patiently...")
    }
}