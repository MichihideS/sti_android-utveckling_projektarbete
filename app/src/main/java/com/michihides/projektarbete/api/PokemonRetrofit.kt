package com.michihides.projektarbete.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.lang.Exception
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

object PokemonRetrofit {
    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val getPokemonApi by lazy {
        retrofit.create<PokemonApi>().getData()
    }

    suspend fun fetchPokemon(): Pokemon {
        return suspendCoroutine { continuation ->
            getPokemonApi.enqueue(object : Callback<Pokemon> {

                override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
                    if (response.isSuccessful) {
                        val pokemon = response.body()
                        if (pokemon != null) {
                            continuation.resume(pokemon)
                        } else {
                            continuation.resumeWithException(Exception("Unsuccessful response: ${response.code()}"))
                        }
                    }
                }

                override fun onFailure(call: Call<Pokemon>, t: Throwable) {
                    println(t.message)
                }
            })
        }
    }
}