package com.example.testvenuscorporation.model

import androidx.compose.ui.graphics.painter.Painter

data class ProductData(
    val nom: String = "",
    val description: String = "",
    val image: Painter? = null
)
