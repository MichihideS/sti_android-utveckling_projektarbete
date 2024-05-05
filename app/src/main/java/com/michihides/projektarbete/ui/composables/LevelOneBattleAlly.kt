package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

fun levelOneBattleAlly(
    pokemonElements: Color,
    pokemonAttackStrength: Int
): Int {
    var enemyHealthLoss = 0

    // Returns how much health the enemy loses based on what element
    enemyHealthLoss = when (pokemonElements) {
        Water -> (pokemonAttackStrength * 1.5).toInt()
        Wind -> (pokemonAttackStrength * 0.5).toInt()
        else -> pokemonAttackStrength
    }

    return enemyHealthLoss
}