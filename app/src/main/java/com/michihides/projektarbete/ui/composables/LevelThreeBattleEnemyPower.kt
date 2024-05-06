package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire

// Calculates how much health the ally loses depending on what element and power the enemy use
fun levelThreeBattleEnemyPower(
    allyElement: Color,
    enemyAttack: String,
): Int {
    var power = 0

    /* Depending on which attack gets randomized, returns how much power the attack
    ** has depending on which element the ally is
     */
    when (enemyAttack) {
        "Blizzard" -> {
            power = when (allyElement) {
                Fire -> 210
                Earth -> 70
                else -> 140
            }
        }

        "Icy Wind" -> {
            power = when (allyElement) {
                Fire -> 120
                Earth -> 40
                else -> 80
            }
        }

        "Wing Attack" -> {
            power = when (allyElement) {
                Earth -> 90
                Fire -> 30
                else -> 60
            }
        }

        "Fly" -> {
            power = when (allyElement) {
                Earth -> 135
                Fire -> 45
                else -> 90
            }
        }
    }

    return power
}


