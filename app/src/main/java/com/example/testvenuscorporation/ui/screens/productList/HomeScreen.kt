package com.example.testvenuscorporation.ui.screens.productList

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.example.testvenuscorporation.R
import com.example.testvenuscorporation.model.ProductData
import com.example.testvenuscorporation.ui.components.ProductComponent


@Composable
fun HomeRoute(
    navigate: (ProductData)-> Unit = {}
){
    Home(
        navigate = navigate
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home(
    navigate: (ProductData) -> Unit
){
    val products = listOf<ProductData>(
        ProductData(nom = " Polo Home 1", description = "POLO CIGALE EN COTON BIO Affichez votre passion pour la Provence avec notre polo à coupe droite finement décoré avec notre cigale intemporelle. Ce polo est confectionné avec soin dans notre propre atelier textile à Aix en Provence. Pour le moment, nos polos bleu ont notre nouvelle cigale, les polos vert sont brodés. ©Sudist - Modèle déposé", image = painterResource(R.drawable.imag1)),
        ProductData(nom = " Polo Home 2", description = "POLO CIGALE EN COTON BIO Affichez votre passion pour la Provence avec notre polo à coupe droite finement décoré avec notre cigale intemporelle. Ce polo est confectionné avec soin dans notre propre atelier textile à Aix en Provence. Pour le moment, nos polos bleu ont notre nouvelle cigale, les polos vert sont brodés. ©Sudist - Modèle déposé", image = painterResource(R.drawable.img2)),
        ProductData(nom = " Polo Home 3", description = "POLO CIGALE EN COTON BIO Affichez votre passion pour la Provence avec notre polo à coupe droite finement décoré avec notre cigale intemporelle. Ce polo est confectionné avec soin dans notre propre atelier textile à Aix en Provence. Pour le moment, nos polos bleu ont notre nouvelle cigale, les polos vert sont brodés. ©Sudist - Modèle déposé", image = painterResource(R.drawable.img3)),
        ProductData(nom = " Polo Home 4", description = "POLO CIGALE EN COTON BIO Affichez votre passion pour la Provence avec notre polo à coupe droite finement décoré avec notre cigale intemporelle. Ce polo est confectionné avec soin dans notre propre atelier textile à Aix en Provence. Pour le moment, nos polos bleu ont notre nouvelle cigale, les polos vert sont brodés. ©Sudist - Modèle déposé", image = painterResource(R.drawable.img4)),
        ProductData(nom = " Polo Home 5", description = "POLO CIGALE EN COTON BIO Affichez votre passion pour la Provence avec notre polo à coupe droite finement décoré avec notre cigale intemporelle. Ce polo est confectionné avec soin dans notre propre atelier textile à Aix en Provence. Pour le moment, nos polos bleu ont notre nouvelle cigale, les polos vert sont brodés. ©Sudist - Modèle déposé", image = painterResource(R.drawable.img5))
    )



    var query by remember {
        mutableStateOf("")
    }

    var showProductSearch by remember {
        mutableStateOf(false)
    }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = showProductSearch)

    Column(
        modifier = Modifier
            .padding(top = 20.dp, start = 10.dp, end = 10.dp)
    ) {
        LazyColumn {
            items(products){product->
                ProductComponent(
                    data = product,
                    navigateToDetails = {prod->
                        navigate(prod)
                    }
                )
            }
        }

        if (showProductSearch){
            ModalBottomSheet(
                onDismissRequest = {}
            ) {
                var productList = products

                val filteredProducts = productList. filter {
                    it.nom.contains(query, ignoreCase = true)
                }

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .background(Color.White)
                    .padding(16.dp))
                {
                    androidx.compose.material3.OutlinedTextField(
                        value = query,
                        onValueChange = { query = it },
                        label = { Text("Rechercher un produit") },
                        modifier = Modifier
                            .background(color = Color.Transparent, shape = RoundedCornerShape(15.dp))
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedBorderColor = Color.Gray.copy(0.4f)
                        ),
                        textStyle = TextStyle(
                            color = Color.Black
                        ),
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    LazyColumn {

                        items(filteredProducts) { product ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                            ) {
                                Text(text = product.nom)
                            }
                        }

                        if (filteredProducts.isEmpty()) {
                            item {
                                Text(
                                    text = "Aucun produit trouvé",
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.Center,

                                    )
                            }
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview(showBackground = true)
fun HomePreview(){
    //Home()
}