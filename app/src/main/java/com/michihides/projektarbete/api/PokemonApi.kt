package com.michihides.projektarbete.api

import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {
    @GET("pokemon/ivysaur")
    fun getData(): Call<Pokemon>
}