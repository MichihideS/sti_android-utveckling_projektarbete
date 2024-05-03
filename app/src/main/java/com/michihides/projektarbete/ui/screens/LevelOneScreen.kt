package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.michihides.projektarbete.ui.composables.AllyPokemonColumn
import com.michihides.projektarbete.ui.composables.BattleMovesButton
import com.michihides.projektarbete.ui.composables.BattleMovesColumn
import com.michihides.projektarbete.ui.composables.ChoosePokemonHandler
import com.michihides.projektarbete.ui.composables.EnemyPokemonColumn
import com.michihides.projektarbete.ui.composables.PokemonAllyDataUI
import com.michihides.projektarbete.ui.composables.PokemonEnemyDataUI
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LevelOneScreen(
    username: String,
    password: String,
    level: Int,
    pokemonChoice: String,
    navigator: DestinationsNavigator
) {
    Column {
        Text(text = username)
        Text(text = password)
        Text(text = "Level $level")
        Text(text = pokemonChoice)
    }
    
    val pokemonAttacks = ChoosePokemonHandler(pokemonChoice = pokemonChoice)

    EnemyPokemonColumn {
        PokemonEnemyDataUI(pokemonName = "charizard")    
    }
    
    AllyPokemonColumn {
        PokemonAllyDataUI(pokemonName = pokemonChoice)
    }
    
    BattleMovesColumn {
        Row {
            BattleMovesButton(buttonText = pokemonAttacks.component1()) {
            }
            BattleMovesButton(buttonText = pokemonAttacks.component2()) {
            }
        }
        Row {
            BattleMovesButton(buttonText = pokemonAttacks.component3()) {
            }
            BattleMovesButton(buttonText = pokemonAttacks.component4()) {
            }
        }
    }
}