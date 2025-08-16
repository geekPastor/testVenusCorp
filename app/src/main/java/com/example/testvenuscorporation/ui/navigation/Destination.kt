package com.example.testvenuscorporation.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptionsBuilder

sealed class Destination(val route: Routes) {
    data object HomeScreen: Destination(Routes.Home)
    data object DetailsScreen: Destination(Routes.Details)

    fun NavController.navigate(
        destination: Destination,
        builder: (NavOptionsBuilder.()-> Unit)? = null
    ){
        if (builder != null){
            try {

                navigate(destination.route.name, builder)
            }catch (e: Exception){
                navigate(destination.route.name)
            }
        }
    }
}