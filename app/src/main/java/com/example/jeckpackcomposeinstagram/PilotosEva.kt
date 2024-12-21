package com.example.jeckpackcomposeinstagram

import androidx.annotation.DrawableRes

data class PilotosEva(
    var nombrePiloto: String,
    var descripcionPiloto: String,
    var unidaPilotada: String, @DrawableRes var photo: Int
)
