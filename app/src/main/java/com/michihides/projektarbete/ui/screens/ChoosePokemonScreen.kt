package com.michihides.projektarbete.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.michihides.projektarbete.ui.composables.ChoosePokemonButton
import com.michihides.projektarbete.ui.composables.PokemonChooseOneDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseThreeDataUI
import com.michihides.projektarbete.ui.composables.PokemonChooseTwoDataUI
import com.michihides.projektarbete.ui.composables.TitleTextNormal
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
@Preview
fun ChoosePokemonScreen() {
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

                }
            }
        }

        Row {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonChooseTwoDataUI(pokemonName = "psyduck")
                ChoosePokemonButton(buttonText = "Psyduck") {

                }
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonChooseThreeDataUI(pokemonName = "lucario")
                ChoosePokemonButton(buttonText = "Lucario") {

                }
            }
        }
    }
}