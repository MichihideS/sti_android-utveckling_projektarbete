package com.michihides.projektarbete.ui.composables

import android.media.MediaPlayer
import android.net.Uri
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import com.michihides.projektarbete.ui.theme.WhiteTransparent
import com.michihides.projektarbete.ui.viewModels.PokemonEnemyViewModel

/* Fetches the Pokemon Data from the API and places it in a viewModel
** This takes the Pokemon name, front Sprite and Cry from the API
 */
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

    /* Sets pokemon as a asyncImage and increases it size, sets the name of the pokemon
    ** as a text with design and saves the sound to a variable long as pokemon isn't null
     */
    if (pokemon != null) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = pokemon?.species?.name.toString().replaceFirstChar { it.uppercase() },
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier
                    .border(2.dp, WhiteTransparent)
                    .padding(10.dp)

                )
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