package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Water
import com.michihides.projektarbete.ui.theme.Wind

fun levelOneBattleEnemy(
    allyElement: Color,
): Pair <Int, String> {
    val randomAttack = (1..4).shuffled().first()

    val attackOne = "Flamethrower"
    val attackTwo = "Flare Blitz"
    val attackThree = "Ember"
    val attackFour = "Tackle"
    var attackChose = ""
    var power = 0

    when (randomAttack) {
        1 -> {
            attackChose = attackOne
            power = when (allyElement) {
                Wind -> 120
                Water -> 40
                else -> 80
            }
        }

        2 -> {
            attackChose = attackTwo
            power = when (allyElement) {
                Wind -> 180
                Water -> 60
                else -> 120
            }
        }

        3 -> {
            attackChose = attackThree
            power = when (allyElement) {
                Wind -> 60
                Water -> 20
                else -> 40
            }
        }

        4 -> {
            attackChose = attackFour
            power = when (allyElement) {
                Wind -> 10
                Water -> 30
                else -> 20
            }
        }
    }

    return Pair(power, attackChose)
}


