package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

// Calculates how much health the ally loses depending on what element and power the enemy use
fun levelTwoBattleEnemyPower(
    allyElement: Color,
    enemyAttack: String,
): Int {
    var power = 0

    /* Depending on which attack gets randomized, returns how much power the attack
    ** has depending on which element the ally is
     */
    when (enemyAttack) {
        "Ice Beam" -> {
            power = when (allyElement) {
                Fire -> 45
                Water -> 135
                else -> 90
            }
        }

        "Dragon Wing" -> {
            power = when (allyElement) {
                Wind -> 40
                Water -> 120
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

        "Outrage" -> {
            power = when (allyElement) {
                Wind -> 50
                Water -> 150
                else -> 100
            }
        }
    }

    return power
}


