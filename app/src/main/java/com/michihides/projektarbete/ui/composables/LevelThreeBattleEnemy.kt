package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

fun levelThreeBattleEnemy(
    allyElement: Color,
): Pair <Int, String> {
    val randomAttack = (1..4).shuffled().first()

    val attackOne = "Blizzard"
    val attackTwo = "Icy Wind"
    val attackThree = "Wing Attack"
    val attackFour = "Fly"
    var attackChose = ""
    var power = 0

    when (randomAttack) {
        1 -> {
            attackChose = attackOne
            power = when (allyElement) {
                Fire -> 210
                Earth -> 70
                else -> 140
            }
        }

        2 -> {
            attackChose = attackTwo
            power = when (allyElement) {
                Fire -> 120
                Earth -> 40
                else -> 80
            }
        }

        3 -> {
            attackChose = attackThree
            power = when (allyElement) {
                Earth -> 90
                Fire -> 30
                else -> 60
            }
        }

        4 -> {
            attackChose = attackFour
            power = when (allyElement) {
                Earth -> 135
                Fire -> 45
                else -> 90
            }
        }
    }

    return Pair(power, attackChose)
}


