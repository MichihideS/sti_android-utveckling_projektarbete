package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

fun levelTwoBattleEnemy(
    allyElement: Color,
): Pair <Int, String> {
    val randomAttack = (1..4).shuffled().first()

    val attackOne = "Ice Beam"
    val attackTwo = "Dragon Wing"
    val attackThree = "Wing Attack"
    val attackFour = "Outrage"
    var attackChose = ""
    var power = 0

    when (randomAttack) {
        1 -> {
            attackChose = attackOne
            power = when (allyElement) {
                Fire -> 45
                Water -> 135
                else -> 90
            }
        }

        2 -> {
            attackChose = attackTwo
            power = when (allyElement) {
                Wind -> 40
                Water -> 120
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
                Wind -> 50
                Water -> 150
                else -> 100
            }
        }
    }

    return Pair(power, attackChose)
}


