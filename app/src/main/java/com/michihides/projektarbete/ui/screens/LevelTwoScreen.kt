package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.composables.AllyPokemonColumn
import com.michihides.projektarbete.ui.composables.BattleMovesButton
import com.michihides.projektarbete.ui.composables.BattleMovesColumn
import com.michihides.projektarbete.ui.composables.ChoosePokemonHandler
import com.michihides.projektarbete.ui.composables.EnemyPokemonColumn
import com.michihides.projektarbete.ui.composables.HealthBar
import com.michihides.projektarbete.ui.composables.HealthBarEnemy
import com.michihides.projektarbete.ui.composables.LevelTwoBattleAlly
import com.michihides.projektarbete.ui.composables.LoserOptions
import com.michihides.projektarbete.ui.composables.PokemonAllyDataUI
import com.michihides.projektarbete.ui.composables.PokemonEnemyDataUI
import com.michihides.projektarbete.ui.composables.WinnerOptions
import com.michihides.projektarbete.ui.composables.levelTwoBattleEnemy
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun LevelTwoScreen(
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
        PokemonEnemyDataUI(pokemonName = "dragonite")
    }

    AllyPokemonColumn {
        PokemonAllyDataUI(pokemonName = pokemonChoice)
    }

    var health by rememberSaveable { mutableIntStateOf((360)) }
    var healthEnemy by rememberSaveable { mutableIntStateOf((420)) }
    var allyElement = Color.Blue

    when (pokemonChoice) {
        "pikachu" -> allyElement = Wind
        "dragonair" -> allyElement = Water
        "jigglypuff" -> allyElement = Earth
    }

    HealthBarEnemy(healthEnemy = healthEnemy)
    HealthBar(health = health)

    BattleMovesColumn {
        Row {
            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component1(),
                buttonTextPower = pokemonAttackStrength.component1(),
                buttonColor = pokemonElements.component1()
            ) {
                healthEnemy -= LevelTwoBattleAlly(
                    pokemonElements = pokemonElements.component1(),
                    pokemonAttackStrength = pokemonAttackStrength.component1()
                )

                val (enemyAttackPower, enemyAttack) = levelTwoBattleEnemy(allyElement)
                health -= enemyAttackPower
            }

            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component2(),
                buttonTextPower = pokemonAttackStrength.component2(),
                buttonColor = pokemonElements.component2()
            ) {
                healthEnemy -= LevelTwoBattleAlly(
                    pokemonElements = pokemonElements.component2(),
                    pokemonAttackStrength = pokemonAttackStrength.component2()
                )

                val (enemyAttackPower, enemyAttack) = levelTwoBattleEnemy(allyElement)
                health -= enemyAttackPower
            }
        }
        Row {
            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component3(),
                buttonTextPower = pokemonAttackStrength.component3(),
                buttonColor = pokemonElements.component3()
            ) {
                healthEnemy -= LevelTwoBattleAlly(
                    pokemonElements = pokemonElements.component3(),
                    pokemonAttackStrength = pokemonAttackStrength.component3()
                )

                val (enemyAttackPower, enemyAttack) = levelTwoBattleEnemy(allyElement)
                health -= enemyAttackPower
            }

            BattleMovesButton(
                buttonTextMove = pokemonAttacks.component4(),
                buttonTextPower = pokemonAttackStrength.component4(),
                buttonColor = pokemonElements.component4()
            ) {
                healthEnemy -= LevelTwoBattleAlly(
                    pokemonElements = pokemonElements.component4(),
                    pokemonAttackStrength = pokemonAttackStrength.component4()
                )

                val (enemyAttackPower, enemyAttack) = levelTwoBattleEnemy(allyElement)
                health -= enemyAttackPower
            }
        }
    }

    if (healthEnemy < 1) {
        WinnerOptions(
            username,
            password,
            level,
            navigator
        )
    }

    if (health < 1 && healthEnemy > 1) {
        LoserOptions(
            username,
            password,
            level,
            navigator)
    }
}