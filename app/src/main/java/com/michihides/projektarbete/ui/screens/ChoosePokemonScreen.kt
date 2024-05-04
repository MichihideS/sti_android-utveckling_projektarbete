package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.michihides.projektarbete.destinations.LevelOneScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.ui.composables.ChoosePokemonButton
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.PokemonChooseOneDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseThreeDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseTwoDataUI
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.michihides.projektarbete.ui.theme.Wind
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun ChoosePokemonScreen(
    username: String,
    password: String,
    level: Int,
    navigator: DestinationsNavigator
) {
    var pokemonChoice: String

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TitleTextNormal(title = "Choose your Pokemon")

        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonChooseOneDataUI(pokemonName = "pikachu")
                ChoosePokemonButton(buttonText = "Pikachu") {
                    pokemonChoice = "pikachu"
                    navigator.navigate(LevelOneScreenDestination(
                        username,
                        password,
                        level,
                        pokemonChoice
                    ))
                }
            }
        }

        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonChooseTwoDataUI(pokemonName = "dragonair")
                ChoosePokemonButton(buttonText = "Dragonair") {
                    pokemonChoice = "dragonair"
                    navigator.navigate(LevelOneScreenDestination(
                        username,
                        password,
                        level,
                        pokemonChoice
                    ))
                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonChooseThreeDataUI(pokemonName = "jigglypuff")
                ChoosePokemonButton(buttonText = "Jigglypuff") {
                    pokemonChoice = "jigglypuff"
                    navigator.navigate(LevelOneScreenDestination(
                        username,
                        password,
                        level,
                        pokemonChoice
                    ))
                }
            }
        }

        MainMenuButton(buttonText = "Back") {
            navigator.navigate(
                LoggedInScreenDestination(
                username,
                password,
                level
                )
            )
        }
    }
}