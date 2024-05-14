package com.michihides.projektarbete.models

import com.michihides.projektarbete.ui.theme.Wind
import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Fire
import com.michihides.projektarbete.ui.theme.Water

// Dragonair class which contains attacks, element and strength
class Dragonair(
    // Pokemon Ally attacks
    val attackOne: String = "Thunderbolt",
    val attackTwo: String = "Dragon Rage",
    val attackThree: String = "Ice Beam",
    val attackFour: String = "Earthquake",

    // Pokemon Ally Elements of attacks
    val elementOne: Color = Wind,
    val elementTwo: Color = Fire,
    val elementThree: Color = Water,
    val elementFour: Color = Earth,

    // Pokemon Strength of attacks
    val strengthOne: Int = 100,
    val strengthTwo: Int = 80,
    val strengthThree: Int = 120,
    val strengthFour: Int = 120,
)