package com.michihides.projektarbete.ui.composables

fun levelTwoBattleEnemyAttack():String {
    // Randoms between attack 1-4
    val randomAttack = (1..4).shuffled().first()

    // Attack names
    val attackOne = "Ice Beam"
    val attackTwo = "Dragon Wing"
    val attackThree = "Wing Attack"
    val attackFour = "Outrage"
    var attackChose = ""

    // Returns the attack that gets randomized
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


