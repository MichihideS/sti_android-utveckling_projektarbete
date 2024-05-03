package com.michihides.projektarbete.ui.composables

import androidx.compose.runtime.Composable
import com.michihides.projektarbete.pokemonMoves.Pikachu

@Composable
fun ChoosePokemonHandler(
    pokemonChoice: String
): List<String> {
    val pokemonAttacks: MutableList<String> = mutableListOf()

    if (pokemonChoice == "pikachu") {
        pokemonAttacks.add(Pikachu().attackOne)
        pokemonAttacks.add(Pikachu().attackTwo)
        pokemonAttacks.add(Pikachu().attackThree)
        pokemonAttacks.add(Pikachu().attackFour)
    }

    return pokemonAttacks
}