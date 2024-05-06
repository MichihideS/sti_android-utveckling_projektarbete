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
import com.michihides.projektarbete.ui.viewModels.PokemonChooseViewModel

/* Fetches the Pokemon Data from the API and places it in a viewModel
** This only fetches the front Sprite for the ally pokemon
 */
@Composable
fun PokemonChooseThreeDataUI(
    pokemonName: String,
    viewModel: PokemonChooseViewModel = viewModel()
) {
    val pokemon by viewModel.pokemonUiState

    // Trigger fetch on initial composition
    LaunchedEffect(true) {
        viewModel.fetchPokemonData(pokemonName)
    }

    // Sets pokemon as a asyncImage and increases it size as long as pokemon isn't null
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