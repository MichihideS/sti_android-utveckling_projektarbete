package com.michihides.projektarbete.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

// Dynamic Interface for retrieving pokemons
interface PokemonApi {
    @GET("pokemon/{name}")
    fun getData(@Path("name") pokemonName: String): Call<Pokemon>
}