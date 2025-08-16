package com.example.testvenuscorporation.ui.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testvenuscorporation.model.ProductData
import com.example.testvenuscorporation.ui.screens.ProductDetails.ProductDetails
import com.example.testvenuscorporation.ui.screens.productList.HomeRoute

@Composable
fun AppNav(
    navController: NavHostController = rememberNavController(),
){
    var product by remember {
        mutableStateOf(ProductData())
    }

    NavHost(
        modifier = Modifier,
        navController = navController,
        startDestination = Destination.HomeScreen.route.name
    ){
        composable(
            route = Destination.HomeScreen.route.name
        ) {
            HomeRoute(
                navigate = {productData ->
                    product = productData
                    navController.navigate(Destination.DetailsScreen.route.name)
                }
            )
        }

        composable(
            route = Destination.DetailsScreen.route.name
        ) {
            ProductDetails(
                productData = product
            )
        }
    }
}