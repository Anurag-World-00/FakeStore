package com.codinghits.fakestore.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codinghits.fakestore.R
import com.codinghits.fakestore.model.Product


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProductItem(
    products: Product = Product(
        id = "1",
        name = "Shoes Pink",
        color = Color.Magenta,
        price = 1200f,
        discountPrice = 1000f,
        rating = 4.7f,
        imageRes = R.drawable.og,
        size = 8
    ),
    onClick: () -> Unit = {}
) {
    var color by remember { mutableStateOf(products.color) }
    var isFav by remember{ mutableStateOf(false)}
    Box(
        modifier = Modifier
            .padding(20.dp)
            .size(168.dp, 210.dp).clickable {
                onClick.invoke()
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(.2f)
                .background(color = color, shape = RoundedCornerShape(22.dp))
        ) {

        }

IconButton(onClick = {isFav = !isFav}, modifier = Modifier.align(Alignment.TopStart)) {
    Icon(imageVector = if(isFav)
                    Icons.Rounded.Favorite
        else
            Icons.Rounded.FavoriteBorder
        , contentDescription = null)


}
        Text(text = products.size.toString(),
fontWeight = FontWeight.Bold,
            color = color.copy(alpha = .3f),
            fontSize = 120.sp,
            modifier = Modifier.align(alignment = Alignment.TopCenter)
            )


Image(painter = painterResource(id = products.imageRes), contentDescription = null,
modifier = Modifier.fillMaxSize(1f).align(Alignment.Center).rotate(-30f).offset(30.dp,(-20).dp)
    )

        Column(modifier = Modifier.align(Alignment.BottomEnd)) {

            Text(text = "Rs. ${products.discountPrice}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(end = 8.dp))
            Text(text = "Rs. ${products.price}",
                    textDecoration = TextDecoration.LineThrough,
                fontSize = 12.sp,
                modifier = Modifier.padding(end = 8.dp).align(Alignment.End))
        }



    }

}