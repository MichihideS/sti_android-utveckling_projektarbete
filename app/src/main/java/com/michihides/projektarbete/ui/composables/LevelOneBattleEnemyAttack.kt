package com.michihides.projektarbete.ui.composables

// Checks which attack the enemy uses
fun levelOneBattleEnemyAttack():String {
    // Randoms between attack 1-4
    val randomAttack = (1..4).shuffled().first()

    // Attack names
    val attackOne = "Flamethrower"
    val attackTwo = "Flare Blitz"
    val attackThree = "Ember"
    val attackFour = "Tackle"
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


