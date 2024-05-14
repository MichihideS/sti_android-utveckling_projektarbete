package com.michihides.projektarbete.ui.composables

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.models.Pikachu
import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.models.Dragonair
import com.michihides.projektarbete.models.Jigglypuff

/* Returns and sets the correct pokemon depending on what you choose with
** the help of Dragonair, Jigglypuff and Pikachu models
 */
@Composable
fun choosePokemonHandler(
    pokemonChoice: String
): Triple<List<String>, List<Color>, List<Int>> {
    val pokemonAttacks: MutableList<String> = mutableListOf()
    val pokemonElements: MutableList<Color> = mutableListOf()
    val pokemonAttackStrength: MutableList<Int> = mutableListOf()

    when (pokemonChoice) {
        "pikachu" -> {
            pokemonAttacks.add(Pikachu().attackOne)
            pokemonAttacks.add(Pikachu().attackTwo)
            pokemonAttacks.add(Pikachu().attackThree)
            pokemonAttacks.add(Pikachu().attackFour)

            pokemonElements.add(Pikachu().elementOne)
            pokemonElements.add(Pikachu().elementTwo)
            pokemonElements.add(Pikachu().elementThree)
            pokemonElements.add(Pikachu().elementFour)

            pokemonAttackStrength.add(Pikachu().strengthOne)
            pokemonAttackStrength.add(Pikachu().strengthTwo)
            pokemonAttackStrength.add(Pikachu().strengthThree)
            pokemonAttackStrength.add(Pikachu().strengthFour)
        }
        "dragonair" -> {
            pokemonAttacks.add(Dragonair().attackOne)
            pokemonAttacks.add(Dragonair().attackTwo)
            pokemonAttacks.add(Dragonair().attackThree)
            pokemonAttacks.add(Dragonair().attackFour)

            pokemonElements.add(Dragonair().elementOne)
            pokemonElements.add(Dragonair().elementTwo)
            pokemonElements.add(Dragonair().elementThree)
            pokemonElements.add(Dragonair().elementFour)

            pokemonAttackStrength.add(Dragonair().strengthOne)
            pokemonAttackStrength.add(Dragonair().strengthTwo)
            pokemonAttackStrength.add(Dragonair().strengthThree)
            pokemonAttackStrength.add(Dragonair().strengthFour)
        }
        "jigglypuff" -> {
            pokemonAttacks.add(Jigglypuff().attackOne)
            pokemonAttacks.add(Jigglypuff().attackTwo)
            pokemonAttacks.add(Jigglypuff().attackThree)
            pokemonAttacks.add(Jigglypuff().attackFour)

            pokemonElements.add(Jigglypuff().elementOne)
            pokemonElements.add(Jigglypuff().elementTwo)
            pokemonElements.add(Jigglypuff().elementThree)
            pokemonElements.add(Jigglypuff().elementFour)

            pokemonAttackStrength.add(Jigglypuff().strengthOne)
            pokemonAttackStrength.add(Jigglypuff().strengthTwo)
            pokemonAttackStrength.add(Jigglypuff().strengthThree)
            pokemonAttackStrength.add(Jigglypuff().strengthFour)
        }
    }

    return Triple(pokemonAttacks, pokemonElements, pokemonAttackStrength)
}