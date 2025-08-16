package com.example.testvenuscorporation.ui.screens.ProductDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testvenuscorporation.model.ProductData

@Composable
fun ProductDetails(
    productData: ProductData
){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = productData.image!!,
            contentDescription = null
        )

        Text(
            text = "Nom du produit: ${productData.nom}"
        )

        Text(
            text = "Nom du produit: ${productData.description}"
        )
    }
}