package com.michihides.projektarbete.ui.composables

import com.michihides.projektarbete.destinations.LevelOneScreenDestination
import com.michihides.projektarbete.destinations.LevelThreeScreenDestination
import com.michihides.projektarbete.destinations.LevelTwoScreenDestination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

fun ChoosePokemon(
    username: String,
    password: String,
    level: Int,
    navigator: DestinationsNavigator,
    pokemonChoice: String
) {
    when (level) {
        1 -> {
            navigator.navigate(
                LevelOneScreenDestination(
                    username,
                    password,
                    level,
                    pokemonChoice


                )
            )
        }

        2 -> {
            navigator.navigate(
                LevelTwoScreenDestination(
                    username,
                    password,
                    level,
                    pokemonChoice


                )
            )
        }

        3 -> {
            navigator.navigate(
                LevelThreeScreenDestination(
                    username,
                    password,
                    level,
                    pokemonChoice


                )
            )
        }
    }
}