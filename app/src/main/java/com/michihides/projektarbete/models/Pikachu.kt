package com.michihides.projektarbete.models

import com.michihides.projektarbete.ui.theme.Wind
import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire

// Pikachu class which contains attacks, element and strength

class Pikachu(
    // Pokemon Ally attacks
    val attackOne: String = "Thunderbolt",
    val attackTwo: String = "Quick Attack",
    val attackThree: String = "Iron Tail",
    val attackFour: String = "Thunder",

    // Pokemon Ally Elements of attacks
    val elementOne: Color = Wind,
    val elementTwo: Color = Fire,
    val elementThree: Color = Earth,
    val elementFour: Color = Wind,

    // Pokemon Strength of attacks
    val strengthOne: Int = 100,
    val strengthTwo: Int = 60,
    val strengthThree: Int = 90,
    val strengthFour: Int = 150,
)