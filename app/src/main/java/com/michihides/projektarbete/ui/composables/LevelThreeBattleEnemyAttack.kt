package com.michihides.projektarbete.ui.composables

fun levelThreeBattleEnemyAttack():String {
    // Randoms between attack 1-4
    val randomAttack = (1..4).shuffled().first()

    // Attack names
    val attackOne = "Blizzard"
    val attackTwo = "Icy Wind"
    val attackThree = "Wing Attack"
    val attackFour = "Fly"
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


