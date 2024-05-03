package com.michihides.projektarbete.api

import com.google.gson.annotations.SerializedName

class Pokemon {
    lateinit var species: Species
    lateinit var sprites: Sprites
    lateinit var cries: Cries
}

class Sprites {
    @SerializedName("front_default")
    var frontSprite: String = ""

    @SerializedName("back_default")
    var backSprite: String = ""
}

class Species {
    var name: String = ""
}

class Cries {
    var latest: String = ""
}