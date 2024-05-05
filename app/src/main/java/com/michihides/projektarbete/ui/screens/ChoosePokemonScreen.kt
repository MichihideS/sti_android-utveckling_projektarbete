package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.michihides.projektarbete.destinations.LevelOneScreenDestination
import com.michihides.projektarbete.destinations.LevelThreeScreenDestination
import com.michihides.projektarbete.destinations.LevelTwoScreenDestination
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.ui.composables.ChoosePokemon
import com.michihides.projektarbete.ui.composables.ChoosePokemonButton
import com.michihides.projektarbete.ui.composables.GameFinished
import com.michihides.projektarbete.ui.composables.MainButtonSound
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.PokemonChooseOneDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseThreeDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseTwoDataUI
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.michihides.projektarbete.ui.composables.WinnerOptions
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

                    ChoosePokemon(
                        username,
                        password,
                        level,
                        navigator,
                        pokemonChoice
                    )
                }


                Row {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PokemonChooseTwoDataUI(pokemonName = "dragonair")
                        ChoosePokemonButton(buttonText = "Dragonair") {
                            pokemonChoice = "dragonair"

                            ChoosePokemon(
                                username,
                                password,
                                level,
                                navigator,
                                pokemonChoice
                            )
                        }
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PokemonChooseThreeDataUI(pokemonName = "jigglypuff")
                        ChoosePokemonButton(buttonText = "Jigglypuff") {
                            pokemonChoice = "jigglypuff"

                            ChoosePokemon(
                                username,
                                password,
                                level,
                                navigator,
                                pokemonChoice
                            )
                        }
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

    if (level > 3) {
        GameFinished(navigator)
    }
}