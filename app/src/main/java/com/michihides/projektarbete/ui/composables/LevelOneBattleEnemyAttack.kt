package com.michihides.projektarbete.ui.composables

import androidx.compose.ui.graphics.Color

fun levelOneBattleEnemyAttack(
    allyElement: Color,
):String {
    val randomAttack = (1..4).shuffled().first()

    val attackOne = "Flamethrower"
    val attackTwo = "Flare Blitz"
    val attackThree = "Ember"
    val attackFour = "Tackle"
    var attackChose = ""

    when (randomAttack) {
        1 -> {
            attackChose = attackOne
        }

        2 -> {
            attackChose = attackTwo
        }


        3 -> {
            attackChose = attackThree
        }

        4 -> {
            attackChose = attackFour
        }
    }

    return attackChose
}


