package com.example.testvenuscorporation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testvenuscorporation.R
import com.example.testvenuscorporation.model.ProductData

@Composable
fun ProductComponent(
    data: ProductData,
    navigateToDetails: (ProductData)->Unit = {}
){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .height(300.dp)
            .clickable(
                onClick = {
                    navigateToDetails(data)
                }
            )
    ){
        Image(
            painter = data.image!!,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = data.nom,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun ProductComponentPreview(){
    //ProductComponent()
}