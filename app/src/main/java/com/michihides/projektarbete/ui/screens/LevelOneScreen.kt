package com.michihides.projektarbete.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.composables.AllyAttack
import com.michihides.projektarbete.ui.composables.AllyPokemonColumn
import com.michihides.projektarbete.ui.composables.BackGroundBattle
import com.michihides.projektarbete.ui.composables.BattleMovesButton
import com.michihides.projektarbete.ui.composables.BattleMovesColumn
import com.michihides.projektarbete.ui.composables.ChoosePokemonHandler
import com.michihides.projektarbete.ui.composables.EnemyAttack
import com.michihides.projektarbete.ui.composables.EnemyChallenge
import com.michihides.projektarbete.ui.composables.EnemyPokemonColumn
import com.michihides.projektarbete.ui.composables.HealthBar
import com.michihides.projektarbete.ui.composables.HealthBarEnemy
import com.michihides.projektarbete.ui.composables.LevelOneBattleAlly
import com.michihides.projektarbete.ui.composables.LoserOptions
import com.michihides.projektarbete.ui.composables.PokemonAllyDataUI
import com.michihides.projektarbete.ui.composables.PokemonEnemyDataUI
import com.michihides.projektarbete.ui.composables.WinnerOptions
import com.michihides.projektarbete.ui.composables.levelOneBattleEnemyAttack
import com.michihides.projektarbete.ui.composables.levelOneBattleEnemyPower
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@Destination
@Composable
fun LevelOneScreen(
    username: String,
    password: String,
    level: Int,
    pokemonChoice: String,
    navigator: DestinationsNavigator
) {
    BackGroundBattle()

    val (pokemonAttacks, pokemonElements, pokemonAttackStrength) = ChoosePokemonHandler(pokemonChoice)

    EnemyPokemonColumn {
        PokemonEnemyDataUI(pokemonName = "charizard")
    }
    
    AllyPokemonColumn {
        PokemonAllyDataUI(pokemonName = pokemonChoice)
    }

    val enemy  = "Charizard"
    var health by rememberSaveable { mutableIntStateOf((360)) }
    var healthEnemy by rememberSaveable { mutableIntStateOf((360)) }
    var allyElement = Color.Blue
    var battleMoves by rememberSaveable { mutableStateOf(false) }
    var afterAttacks by rememberSaveable { mutableStateOf(false) }
    var afterEnemyAttacks by rememberSaveable { mutableStateOf(false) }
    var allyAttack by rememberSaveable { mutableStateOf("") }
    var allyAttackPower by rememberSaveable { mutableIntStateOf(0) }
    var allyAttackElement = Color.Blue
    var enemyAttackPower by rememberSaveable { mutableIntStateOf(0) }
    var enemyAttack by rememberSaveable { mutableStateOf("") }


    when (pokemonChoice) {
        "pikachu" -> allyElement = Wind
        "dragonair" -> allyElement = Water
        "jigglypuff" -> allyElement = Earth
    }

    LaunchedEffect(Unit) {
        delay(3200)
        battleMoves = true
    }

    HealthBarEnemy(healthEnemy = healthEnemy)
    HealthBar(health = health)

    EnemyChallenge(enemy = "Charizard")
    
    AnimatedVisibility(visible = battleMoves) {
        BattleMovesColumn {
            Row {
                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component1(),
                    buttonTextPower = pokemonAttackStrength.component1(),
                    buttonColor = pokemonElements.component1()
                ) {
                    allyAttack = pokemonAttacks.component1()
                    allyAttackPower = pokemonAttackStrength.component1()
                    allyAttackElement = pokemonElements.component1()
                    enemyAttack = levelOneBattleEnemyAttack(allyElement)
                    afterAttacks = true
                    battleMoves = false
                }

                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component2(),
                    buttonTextPower = pokemonAttackStrength.component2(),
                    buttonColor = pokemonElements.component2()
                ) {
                    healthEnemy -= LevelOneBattleAlly(
                        pokemonElements = pokemonElements.component2(),
                        pokemonAttackStrength = pokemonAttackStrength.component2()
                    )

                    //val (enemyAttackPower, enemyAttack) = levelOneBattleEnemy(allyElement)
                    health -= enemyAttackPower
                }
            }
            Row {
                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component3(),
                    buttonTextPower = pokemonAttackStrength.component3(),
                    buttonColor = pokemonElements.component3()
                ) {
                    healthEnemy -= LevelOneBattleAlly(
                        pokemonElements = pokemonElements.component3(),
                        pokemonAttackStrength = pokemonAttackStrength.component3()
                    )

                    //val (enemyAttackPower, enemyAttack) = levelOneBattleEnemy(allyElement)
                    health -= enemyAttackPower
                }

                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component4(),
                    buttonTextPower = pokemonAttackStrength.component4(),
                    buttonColor = pokemonElements.component4()
                ) {
                    healthEnemy -= LevelOneBattleAlly(
                        pokemonElements = pokemonElements.component4(),
                        pokemonAttackStrength = pokemonAttackStrength.component4()
                    )

                    //val (enemyAttackPower, enemyAttack) = levelOneBattleEnemy(allyElement)
                    health -= enemyAttackPower
                }
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

    AnimatedVisibility (afterAttacks) {
        AllyAttack(attack = allyAttack)

        LaunchedEffect(Unit) {
            delay(1000)
            healthEnemy -= LevelOneBattleAlly(
                pokemonElements = allyAttackElement,
                pokemonAttackStrength = allyAttackPower
            )

            delay(1200)
            afterEnemyAttacks = true
        }
    }

    AnimatedVisibility (afterEnemyAttacks && healthEnemy > 1) {
        afterAttacks = false

        enemyAttackPower = levelOneBattleEnemyPower(allyElement, enemyAttack)

        EnemyAttack(enemy = enemy, attack = enemyAttack)

        LaunchedEffect(Unit) {
            delay(1000)
            health -= enemyAttackPower

            delay(1200)
            battleMoves = true
            afterEnemyAttacks = false
        }
    }
}


