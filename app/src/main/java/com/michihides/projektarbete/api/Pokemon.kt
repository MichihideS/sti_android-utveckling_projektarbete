package com.michihides.projektarbete.api

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val sprites: Sprites
)

data class Sprites(
    @SerializedName("front_default")
    val frontSprite: String
)
