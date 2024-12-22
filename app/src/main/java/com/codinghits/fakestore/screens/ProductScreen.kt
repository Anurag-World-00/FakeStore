package com.codinghits.fakestore.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.codinghits.fakestore.R
import com.codinghits.fakestore.model.Product
import com.codinghits.fakestore.navigation.NavigationItems
import com.codinghits.fakestore.screens.components.ProductItem

@Composable
fun ProductScreen(modifier: Modifier = Modifier, navController: NavHostController) {
    val products = remember{ getProductList()}

    LazyVerticalGrid(columns = GridCells.Fixed(2), modifier = Modifier.padding(8.dp)) {
        items(products){
            ProductItem(products = it){
            navController.navigate("${NavigationItems.PRODUCT_DETAILS}/${it.id}")}
        }

    }

}
fun getProductList() : List<Product> {
    return listOf(
        Product(
            id = "1",
            name = "Shoes Pink",
            color = Color.Magenta,
            price = 1200f,
            discountPrice = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "2",
            name = "Shoes Yellow",
            color = Color.Yellow,
            price = 1200f,
            discountPrice = 1000f,
            rating = 4.7f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "3",
            name = "Shoes Cyan",
            color = Color.Cyan,
            price = 4200f,
            discountPrice = 1500f,
            rating = 3.7f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "4",
            name = "Shoes Blue",
            color = Color.Blue,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "5",
            name = "Shoes Pink",
            color = Color.Magenta,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "6",
            name = "Shoes Blue",
            color = Color.Blue,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "7",
            name = "Shoes Pink",
            color = Color.Magenta,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "8",
            name = "Shoes Blue",
            color = Color.Blue,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "9",
            name = "Shoes Pink",
            color = Color.Magenta,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
        Product(
            id = "10",
            name = "Shoes Yellow",
            color = Color.Yellow,
            price = 1500f,
            discountPrice = 1500f,
            rating = 4.3f,
            imageRes = R.drawable.og,
            size = 8
        ),
    )
}