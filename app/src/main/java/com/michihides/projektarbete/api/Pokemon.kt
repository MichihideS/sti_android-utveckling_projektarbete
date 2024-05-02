package com.michihides.projektarbete.api

import com.google.gson.annotations.SerializedName

class Pokemon {
    lateinit var sprites: Sprites
}

class Sprites {
    @SerializedName("front_default")
    var frontSprite: String = ""
}