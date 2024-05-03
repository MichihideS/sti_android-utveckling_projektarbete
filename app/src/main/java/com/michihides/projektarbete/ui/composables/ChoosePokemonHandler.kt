package com.michihides.projektarbete.ui.composables

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.models.Pikachu
import androidx.compose.ui.graphics.Color

@Composable
fun ChoosePokemonHandler(
    pokemonChoice: String
): Triple<List<String>, List<Color>, List<Int>> {
    val pokemonAttacks: MutableList<String> = mutableListOf()
    val pokemonElements: MutableList<Color> = mutableListOf()
    val pokemonAttackStrength: MutableList<Int> = mutableListOf()

    if (pokemonChoice == "pikachu") {
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

    return Triple(pokemonAttacks, pokemonElements, pokemonAttackStrength)
}