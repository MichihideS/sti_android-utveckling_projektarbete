package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

fun LevelTwoBattleAlly(
    pokemonElements: Color,
    pokemonAttackStrength: Int
): Int {
    var enemyHealthLoss = 0

    enemyHealthLoss = when (pokemonElements) {
        Wind -> (pokemonAttackStrength * 1.5).toInt()
        Water -> (pokemonAttackStrength * 0.5).toInt()
        else -> pokemonAttackStrength
    }

    return enemyHealthLoss
}