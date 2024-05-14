package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

// Calculates how much health the enemy loses depending on what element and power you use
fun levelOneBattleAlly(
    pokemonElements: Color,
    pokemonAttackStrength: Int
): Int {
    // Returns how much health the enemy loses based on what element
    val enemyHealthLoss = when (pokemonElements) {
        Water -> (pokemonAttackStrength * 1.5).toInt()
        Wind -> (pokemonAttackStrength * 0.5).toInt()
        else -> pokemonAttackStrength
    }

    return enemyHealthLoss
}