package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

// Calculates how much health the ally loses depending on what element and power the enemy use
fun levelOneBattleEnemyPower(
    allyElement: Color,
    enemyAttack: String,
): Int {
    var power = 0

    /* Depending on which attack gets randomized, returns how much power the attack
    ** has depending on which element the ally is
     */
    when (enemyAttack) {
        "Flamethrower" -> {
            power = when (allyElement) {
                Wind -> 120
                Water -> 40
                else -> 80
            }
        }

        "Flare Blitz" -> {
            power = when (allyElement) {
                Wind -> 180
                Water -> 60
                else -> 120
            }
        }

        "Ember" -> {
            power = when (allyElement) {
                Wind -> 60
                Water -> 20
                else -> 40
            }
        }

        "Tackle" -> {
            power = when (allyElement) {
                Wind -> 10
                Water -> 30
                else -> 20
            }
        }
    }

    return power
}


