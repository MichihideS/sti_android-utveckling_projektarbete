package com.michihides.projektarbete.ui.screens

import android.media.MediaPlayer
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.michihides.projektarbete.R
import com.michihides.projektarbete.ui.composables.AllyAttack
import com.michihides.projektarbete.ui.composables.AllyPokemonColumn
import com.michihides.projektarbete.ui.composables.BackGroundBattle
import com.michihides.projektarbete.ui.composables.BattleMovesButton
import com.michihides.projektarbete.ui.composables.BattleMovesColumn
import com.michihides.projektarbete.ui.composables.ElementCircleSmall
import com.michihides.projektarbete.ui.composables.EnemyAttack
import com.michihides.projektarbete.ui.composables.EnemyChallenge
import com.michihides.projektarbete.ui.composables.EnemyPokemonColumn
import com.michihides.projektarbete.ui.composables.HealthBar
import com.michihides.projektarbete.ui.composables.HealthBarEnemy
import com.michihides.projektarbete.ui.composables.LoserOptions
import com.michihides.projektarbete.ui.composables.PokemonAllyDataUI
import com.michihides.projektarbete.ui.composables.PokemonEnemyDataUI
import com.michihides.projektarbete.ui.composables.WinnerOptions
import com.michihides.projektarbete.ui.composables.choosePokemonHandler
import com.michihides.projektarbete.ui.composables.levelOneBattleAlly
import com.michihides.projektarbete.ui.composables.levelOneBattleEnemyAttack
import com.michihides.projektarbete.ui.composables.levelOneBattleEnemyPower
import com.michihides.projektarbete.ui.composables.levelThreeBattleAlly
import com.michihides.projektarbete.ui.composables.levelThreeBattleEnemyAttack
import com.michihides.projektarbete.ui.composables.levelThreeBattleEnemyPower
import com.michihides.projektarbete.ui.composables.levelTwoBattleAlly
import com.michihides.projektarbete.ui.composables.levelTwoBattleEnemyAttack
import com.michihides.projektarbete.ui.composables.levelTwoBattleEnemyPower
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

@Destination
@Composable
fun BattleScreen(
    username: String,
    password: String,
    level: Int,
    pokemonChoice: String,
    navigator: DestinationsNavigator
) {
    var enemy  = ""

    // Checks which level you are and assign you the right battle
    when (level) {
        1 -> enemy = "Charizard"
        2 -> enemy = "Dragonite"
        3 -> enemy = "Articuno"
    }
    // Sets a background
    BackGroundBattle()

    // Sets the pokemon you choose with the right attacks, elements and power
    val (pokemonAttacks, pokemonElements, pokemonAttackStrength) = choosePokemonHandler(pokemonChoice)

    // Fetches Charizard from the API with name, sound and sprite
    EnemyPokemonColumn {
        PokemonEnemyDataUI(pokemonName = enemy.lowercase())
    }

    // Fetches the pokemon you choose with sprite
    AllyPokemonColumn {
        PokemonAllyDataUI(pokemonName = pokemonChoice)
    }

    var health by rememberSaveable { mutableIntStateOf((360)) }
    var healthEnemy by rememberSaveable { mutableIntStateOf((0)) }
    var allyAttack by rememberSaveable { mutableStateOf("") }
    var allyAttackPower by rememberSaveable { mutableIntStateOf(0) }

    // Element of the pokemon you choose
    var allyElement by remember { mutableStateOf(Color.Blue) }

    // Element of the attack you are using
    var allyAttackElement by remember { mutableStateOf(Color.Blue) }

    var enemyAttackPower by rememberSaveable { mutableIntStateOf(0) }
    var enemyAttack by rememberSaveable { mutableStateOf("") }

    // Boolean that shows the different attacks you can use if set to true
    var battleMoves by rememberSaveable { mutableStateOf(false) }

    // Boolean that show what attack you choose if set to true
    var afterAttacks by rememberSaveable { mutableStateOf(false) }

    // Boolean that shows the enemy attack if set to true
    var afterEnemyAttacks by rememberSaveable { mutableStateOf(false) }

    // Boolean that stops the music from playing if set to true and after button press
    var silenceMusic by rememberSaveable { mutableStateOf(false) }

    // Boolean that sets the enemy health 1 time
    var setEnemyHealth by rememberSaveable { mutableStateOf(true) }

    // Sets the enemy health depending on which enemy it is
    if (setEnemyHealth) {
        when (enemy) {
            "Charizard" -> healthEnemy = 380
            "Dragonite" -> healthEnemy = 420
            "Articuno" -> healthEnemy = 520
        }
    }


    // Sets your pokemons element
    when (pokemonChoice) {
        "pikachu" -> allyElement = Wind
        "dragonair" -> allyElement = Water
        "jigglypuff" -> allyElement = Earth
    }

    // Shows the battle menu after 3200ms
    LaunchedEffect(Unit) {
        delay(3200)
        battleMoves = true
    }

    // Enemy health bar and your health bar
    HealthBarEnemy(healthEnemy = healthEnemy)
    HealthBar(health = health)

    // Small Element Circle that helps you with attacks
    ElementCircleSmall()

    // Pretext that shows who you are facing
    EnemyChallenge(enemy = enemy)

    /* Need to use context when using a composable function
    ** When in fragment or activity you can use this
    */
    val context = LocalContext.current

    val sound by remember {
        mutableStateOf(MediaPlayer.create(context, R.raw.battle_music))
    }

    // Releases the sound when switching composable
    DisposableEffect(Unit) {
        onDispose {
            sound.release()
        }
    }

    LaunchedEffect(Unit) {
        delay(850)
        // Lowers the volume of the music
        sound.setVolume(0.5f, 0.5f)
        sound.start()
    }

    if (silenceMusic) {
        // Releases the sound when switching composable
        DisposableEffect(Unit) {
            onDispose {
                sound.release()
            }
        }
    }

    // Battle menu that shows when you can attack the enemy
    AnimatedVisibility(visible = battleMoves) {
        BattleMovesColumn {
            Row {
                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component1(),
                    buttonTextPower = pokemonAttackStrength.component1(),
                    buttonColor = pokemonElements.component1()
                ) {
                    // Sets what attack you choose, how much power if has and what element it is
                    allyAttack = pokemonAttacks.component1()
                    allyAttackPower = pokemonAttackStrength.component1()
                    allyAttackElement = pokemonElements.component1()

                    // Randomizes the enemy attack
                    when (level) {
                        1 -> enemyAttack = levelOneBattleEnemyAttack()
                        2 -> enemyAttack = levelTwoBattleEnemyAttack()
                        3 -> enemyAttack = levelThreeBattleEnemyAttack()
                    }

                    setEnemyHealth = false
                    afterAttacks = true
                    battleMoves = false
                }

                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component2(),
                    buttonTextPower = pokemonAttackStrength.component2(),
                    buttonColor = pokemonElements.component2()
                ) {
                    // Sets what attack you choose, how much power if has and what element it is
                    allyAttack = pokemonAttacks.component2()
                    allyAttackPower = pokemonAttackStrength.component2()
                    allyAttackElement = pokemonElements.component2()

                    // Randomizes the enemy attack
                    when (level) {
                        1 -> enemyAttack = levelOneBattleEnemyAttack()
                        2 -> enemyAttack = levelTwoBattleEnemyAttack()
                        3 -> enemyAttack = levelThreeBattleEnemyAttack()
                    }

                    setEnemyHealth = false
                    afterAttacks = true
                    battleMoves = false
                }
            }
            Row {
                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component3(),
                    buttonTextPower = pokemonAttackStrength.component3(),
                    buttonColor = pokemonElements.component3()
                ) {
                    // Sets what attack you choose, how much power if has and what element it is
                    allyAttack = pokemonAttacks.component3()
                    allyAttackPower = pokemonAttackStrength.component3()
                    allyAttackElement = pokemonElements.component3()

                    // Randomizes the enemy attack
                    when (level) {
                        1 -> enemyAttack = levelOneBattleEnemyAttack()
                        2 -> enemyAttack = levelTwoBattleEnemyAttack()
                        3 -> enemyAttack = levelThreeBattleEnemyAttack()
                    }

                    setEnemyHealth = false
                    afterAttacks = true
                    battleMoves = false
                }

                BattleMovesButton(
                    buttonTextMove = pokemonAttacks.component4(),
                    buttonTextPower = pokemonAttackStrength.component4(),
                    buttonColor = pokemonElements.component4()
                ) {
                    // Sets what attack you choose, how much power if has and what element it is
                    allyAttack = pokemonAttacks.component4()
                    allyAttackPower = pokemonAttackStrength.component4()
                    allyAttackElement = pokemonElements.component4()

                    // Randomizes the enemy attack
                    when (level) {
                        1 -> enemyAttack = levelOneBattleEnemyAttack()
                        2 -> enemyAttack = levelTwoBattleEnemyAttack()
                        3 -> enemyAttack = levelThreeBattleEnemyAttack()
                    }

                    setEnemyHealth = false
                    afterAttacks = true
                    battleMoves = false
                }
            }
        }
    }

    // Shows what attack you use and calculates how much damaged it did to the enemy
    AnimatedVisibility (afterAttacks) {
        AllyAttack(attack = allyAttack)

        LaunchedEffect(Unit) {
            delay(1000)
            when (level) {
                1 -> healthEnemy -= levelOneBattleAlly(
                        pokemonElements = allyAttackElement,
                        pokemonAttackStrength = allyAttackPower
                    )
                2 -> healthEnemy -= levelTwoBattleAlly(
                    pokemonElements = allyAttackElement,
                    pokemonAttackStrength = allyAttackPower
                )
                3 -> healthEnemy -= levelThreeBattleAlly(
                    pokemonElements = allyAttackElement,
                    pokemonAttackStrength = allyAttackPower
                )
            }

            delay(1200)
            afterEnemyAttacks = true
        }
    }

    /* Shows the attack your enemy use and calculate how much damage it did to you
    ** After a delay the battle menu will come up again and rotate the procedure until
    ** one of the health / enemyHealth reaches 0 or lower
     */
    AnimatedVisibility (afterEnemyAttacks && healthEnemy > 1) {
        afterAttacks = false

        when (level) {
            1 -> enemyAttackPower = levelOneBattleEnemyPower(allyElement, enemyAttack)
            2 -> enemyAttackPower = levelTwoBattleEnemyPower(allyElement, enemyAttack)
            3 -> enemyAttackPower = levelThreeBattleEnemyPower(allyElement, enemyAttack)
        }

        EnemyAttack(enemy = enemy, attack = enemyAttack)

        LaunchedEffect(Unit) {
            delay(1000)
            health -= enemyAttackPower

            delay(1200)
            battleMoves = true
            afterEnemyAttacks = false
        }
    }

    // If enemy health goes to 0 you win and WinnerOptions show
    if (healthEnemy < 1) {
        silenceMusic = true
        battleMoves = false
        WinnerOptions(
            username,
            password,
            level,
            navigator
        )
    }

    // If your health goes to 0 you lose and LoserOptions show
    if (health < 1 && healthEnemy > 1) {
        silenceMusic = true
        battleMoves = false
        LoserOptions(
            username,
            password,
            level,
            navigator)
    }
}


