package com.michihides.projektarbete.api

import com.google.gson.annotations.SerializedName

// Pokemon variables from the API
class Pokemon {
    // Since everything had parent routes
    lateinit var species: Species
    lateinit var sprites: Sprites
    lateinit var cries: Cries
}

// Sprites of the Pokemon, front and back
class Sprites {
    @SerializedName("front_default")
    var frontSprite: String = ""

    @SerializedName("back_default")
    var backSprite: String = ""
}

// Name of the Pokemon
class Species {
    var name: String = ""
}

// Cry of the Pokemon
class Cries {
    var latest: String = ""
}