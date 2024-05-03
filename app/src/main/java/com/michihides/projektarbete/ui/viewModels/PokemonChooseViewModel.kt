package com.michihides.projektarbete.ui.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.michihides.projektarbete.api.PokemonRetrofit
import com.michihides.projektarbete.api.Pokemon
import kotlinx.coroutines.launch

class PokemonChooseViewModel: ViewModel() {
    private val _pokemonUiState = mutableStateOf<Pokemon?>(null)
    var pokemonUiState: State<Pokemon?> = _pokemonUiState

    fun fetchPokemonData(pokemonName: String) {
        viewModelScope.launch {
            try {
                _pokemonUiState.value = PokemonRetrofit.fetchPokemon(pokemonName)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}