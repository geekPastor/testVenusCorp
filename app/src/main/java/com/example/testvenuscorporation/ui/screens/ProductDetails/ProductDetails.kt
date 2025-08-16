package com.example.testvenuscorporation.ui.screens.ProductDetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
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
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = productData.image!!,
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Nom du produit: ${productData.nom}"
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Description du produit: ${productData.description}"
        )
    }
}