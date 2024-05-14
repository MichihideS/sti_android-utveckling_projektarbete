package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire

// Calculates how much health the enemy loses depending on what element and power you use
fun levelThreeBattleAlly(
    pokemonElements: Color,
    pokemonAttackStrength: Int
): Int {
    // Returns how much health the enemy loses based on what element
    val enemyHealthLoss = when (pokemonElements) {
        Earth -> (pokemonAttackStrength * 1.5).toInt()
        Fire -> (pokemonAttackStrength * 0.5).toInt()
        else -> pokemonAttackStrength
    }

    return enemyHealthLoss
}