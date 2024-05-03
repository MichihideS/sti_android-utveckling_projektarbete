package com.michihides.projektarbete.models

import androidx.compose.ui.graphics.Color
import com.michihides.projektarbete.ui.theme.Earth
import com.michihides.projektarbete.ui.theme.Water

// User Object which contains a username, password and level
class Jigglypuff(
    // Pokemon Ally attacks
    val attackOne: String = "Pound",
    val attackTwo: String = "Quick Attack",
    val attackThree: String = "Water Gun",
    val attackFour: String = "Low Kick",

    // Pokemon Ally Elements of attacks
    val elementOne: Color = Earth,
    val elementTwo: Color = Earth,
    val elementThree: Color = Water,
    val elementFour: Color = Earth,

    // Pokemon Strength of attacks
    val strengthOne: Int = 50,
    val strengthTwo: Int = 80,
    val strengthThree: Int = 60,
    val strengthFour: Int = 90,
)