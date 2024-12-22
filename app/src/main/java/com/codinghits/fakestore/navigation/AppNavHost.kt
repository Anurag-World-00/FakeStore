package com.codinghits.fakestore.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.codinghits.fakestore.screens.ProductDetailScreen
import com.codinghits.fakestore.screens.ProductScreen


@Composable
fun AppNavHost(modifier: Modifier = Modifier , startDestination : String = NavigationItems.PRODUCT ) {
    val navController = rememberNavController()
NavHost(navController = navController , startDestination = startDestination){
    composable(NavigationItems.PRODUCT) {
ProductScreen(navController = navController)
    }
    composable("${NavigationItems.PRODUCT_DETAILS}/{id}" , arguments = listOf(navArgument("id"){type = NavType.StringType})) {
        val id = it.arguments!!.getString("id")
        if (id != null) {
            ProductDetailScreen(id, navController = navController)
        }
    }
}

}