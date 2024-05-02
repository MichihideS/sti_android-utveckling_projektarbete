package com.michihides.projektarbete.api

import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon/gardevoir")
    fun getData(): Call<Pokemon>
}