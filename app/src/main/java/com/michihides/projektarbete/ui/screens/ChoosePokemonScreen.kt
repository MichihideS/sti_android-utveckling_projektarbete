package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.michihides.projektarbete.R
import com.michihides.projektarbete.destinations.LoggedInScreenDestination
import com.michihides.projektarbete.ui.composables.ChoosePokemonButton
import com.michihides.projektarbete.ui.composables.GameFinished
import com.michihides.projektarbete.ui.composables.MainMenuButton
import com.michihides.projektarbete.ui.composables.PokemonChooseOneDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseThreeDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseTwoDataUI
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.michihides.projektarbete.ui.composables.choosePokemon
import com.michihides.projektarbete.ui.theme.GeneralBackground
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

    // Boolean that checks if you are done with the game
    var gameFinished by rememberSaveable { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(GeneralBackground)
    ) {
        TitleTextNormal(title = stringResource(id = R.string.choose_pokemon))

        if (!gameFinished) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    PokemonChooseOneDataUI(pokemonName = "pikachu")
                    ChoosePokemonButton(buttonText = "Pikachu") {
                        pokemonChoice = "pikachu"

                        choosePokemon(
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

                                choosePokemon(
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

                                choosePokemon(
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

                MainMenuButton(buttonText = stringResource(id = R.string.back)) {
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
    }

    // If level is above 3 calls the GameFinished()
    if (level > 3) {
        gameFinished = true
        GameFinished(navigator)
    }
}