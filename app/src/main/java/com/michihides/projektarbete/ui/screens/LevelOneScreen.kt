package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.michihides.projektarbete.ui.composables.AllyPokemonColumn
import com.michihides.projektarbete.ui.composables.BattleMovesButton
import com.michihides.projektarbete.ui.composables.BattleMovesColumn
import com.michihides.projektarbete.ui.composables.ChoosePokemonHandler
import com.michihides.projektarbete.ui.composables.EnemyPokemonColumn
import com.michihides.projektarbete.ui.composables.HealthBar
import com.michihides.projektarbete.ui.composables.HealthBarEnemy
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

    val (pokemonAttacks, pokemonElements, pokemonAttackStrength) = ChoosePokemonHandler(pokemonChoice)

    EnemyPokemonColumn {
        PokemonEnemyDataUI(pokemonName = "charizard")
    }
    
    AllyPokemonColumn {
        PokemonAllyDataUI(pokemonName = pokemonChoice)
    }
    
    var health by rememberSaveable { mutableIntStateOf((360)) }
    var healthEnemy by rememberSaveable { mutableIntStateOf((360)) }

    HealthBarEnemy(healthEnemy = healthEnemy)
    HealthBar(health = health)
    
    BattleMovesColumn {
        Row {
            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component1(),
                buttonTextPower = pokemonAttackStrength.component1(),
                buttonColor = pokemonElements.component1()
            ) {
                healthEnemy = 300
            }

           BattleMovesButton(
               buttonTextMove = pokemonAttacks.component2(),
               buttonTextPower = pokemonAttackStrength.component2(),
               buttonColor = pokemonElements.component2()
           ) {
                health = 200
           }
        }
        Row {
            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component3(),
                buttonTextPower = pokemonAttackStrength.component3(),
                buttonColor = pokemonElements.component3()
            ) {

            }

            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component4(),
                buttonTextPower = pokemonAttackStrength.component4(),
                buttonColor = pokemonElements.component4()
            ) {

            }
        }
    }
}