package com.codinghits.fakestore.screens

import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay


@Composable
fun ProductDetailScreen(productId: String = "1", navController: NavHostController) {
    var product = getProductList().find {
        it.id == productId
    }!!

    var xOffset by remember { mutableStateOf(800.dp) }
    var yOffset by remember { mutableStateOf(800.dp) }

    val animationXOffset = animateDpAsState(
        targetValue = xOffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    val animationYOffset = animateDpAsState(
        targetValue = yOffset,
        label = "",
        animationSpec = tween(durationMillis = 600, easing = FastOutLinearInEasing)
    )
    var selectedColor by remember { mutableStateOf(product.color) }
    var productScale by remember { mutableFloatStateOf(0.6f) }
    val animationProductScale = animateFloatAsState(targetValue = productScale, label = "")
    var productRotate by remember { mutableFloatStateOf(-60f) }
    val animationProductRotate = animateFloatAsState(targetValue = productRotate, label = "")
    var selectedSize by remember {
        mutableStateOf(product.size.toString())
    }
    var isFav by remember { mutableStateOf(false) }
    LaunchedEffect(true) {
        delay(150)
        xOffset = 140.dp
        yOffset = (-130).dp
        productScale = 1f
        productRotate = -30f
    }
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .offset(
                    x = animationXOffset.value,
                    y = animationYOffset.value
                )
                .alpha(.3f)
                .size(400.dp)
                .background(
                    color = selectedColor,
                    shape = CircleShape,

                    )
        )

        IconButton(
            onClick = {navController.popBackStack()}, modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .shadow(
                    elevation = 24.dp,
                    spotColor = DefaultShadowColor,
                    shape = RoundedCornerShape(12.dp)
                )
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(22.dp)
                )
                .size(36.dp)

        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowLeft,
                contentDescription = null
            )
        }


        Column(modifier = Modifier) {
            Image(
                painter = painterResource(id = product.imageRes), contentDescription = null,

                modifier = Modifier
                    .scale(animationProductScale.value)
                    .rotate(animationProductRotate.value)
                    .padding(end = 48.dp, top = 30.dp)
                    .size(330.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column {
                    Text(
                        text = "Sneakers",
                        color = Color.Black,
                        fontSize = 10.sp,
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                    )

                    Text(
                        text = product.name,
                        color = Color.Black,
                        fontSize = 22.sp,
                        modifier = Modifier.padding(top = 2.dp),
                        style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                    )
                    Row(
                        modifier = Modifier.padding(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Star,
                            modifier = Modifier.size(18.dp),
                            contentDescription = null,
                            tint = Color(0xFFFFDA45)
                        )
                        Text(
                            text = product.rating.toString(),
                            color = Color.Black,
                            fontSize = 12.sp,
                            modifier = Modifier.padding(start = 4.dp),
                            style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                        )
                    }
                }
                Text(
                    text = "Rs. ${product.discountPrice}",
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.Black,
                    fontSize = 36.sp,
                    style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
                )


            }
            Text(
                text = "Size",
                modifier = Modifier.padding(horizontal = 22.dp),
                color = Color.Black,
                fontSize = 10.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    fontWeight = FontWeight.Bold
                )
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                ProductSizeCard(size = "8", isSelected = selectedSize == "8") { selectedSize = "8" }
                ProductSizeCard(size = "9", isSelected = selectedSize == "9") { selectedSize = "9" }
                ProductSizeCard(size = "10", isSelected = selectedSize == "10") {
                    selectedSize = "10"
                }
                ProductSizeCard(size = "11", isSelected = selectedSize == "11") {
                    selectedSize = "11"
                }
                ProductSizeCard(size = "12", isSelected = selectedSize == "12") {
                    selectedSize = "12"
                }
                ProductSizeCard(size = "13", isSelected = selectedSize == "13") {
                    selectedSize = "13"
                }
            }

            Text(
                text = "Color",
                modifier = Modifier
                    .padding(top = 24.dp)
                    .padding(horizontal = 22.dp),
                color = Color.Black,
                fontSize = 10.sp,
                style = TextStyle(
                    platformStyle = PlatformTextStyle(includeFontPadding = false)
                ),
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                ProductColor(
                    color = Color.Green,
                    isSelected = selectedColor == Color.Green
                ) { selectedColor = Color.Green }
                ProductColor(
                    color = Color.Blue,
                    isSelected = selectedColor == Color.Blue
                ) { selectedColor = Color.Blue }
                ProductColor(
                    color = Color.Red,
                    isSelected = selectedColor == Color.Red
                ) { selectedColor = Color.Red }
                ProductColor(
                    color = Color.Yellow,
                    isSelected = selectedColor == Color.Yellow
                ) { selectedColor = Color.Yellow }
                ProductColor(
                    color = Color.Cyan,
                    isSelected = selectedColor == Color.Cyan
                ) { selectedColor = Color.Cyan }
            }
            Text(
                text = "Android development is the process of creating software applications for devices running the Android operating system. These applications can range from simple utilities to complex games and productivity tools. ",
                modifier = Modifier
                    .padding(top = 6.dp)
                    .padding(horizontal = 22.dp),
                color = Color.Black,
                fontWeight = FontWeight.Light,
                style = TextStyle(platformStyle = PlatformTextStyle(includeFontPadding = false))
            )
            Spacer(Modifier.weight(1f))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
                    .padding(horizontal = 22.dp),
            ) {

                IconButton(onClick = { isFav = !isFav }) {
                    Icon(
                        imageVector = if (isFav) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                        contentDescription = null,
                        tint = if (isFav) Color.Red else MaterialTheme.colorScheme.onSurface
                    )
                }
                Spacer(Modifier.width(4.dp))
                Button(
                    onClick = {},
                    modifier = Modifier

                        .fillMaxWidth()
                        .height(48.dp)
                        .padding(start = 8.dp),
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Blue
                    )
                ) {
                    Icon(imageVector = Icons.Rounded.ShoppingCart  , contentDescription = null)
                    Text(text = "Add to cart")
                }
            }

        }


    }

}


@Composable
fun ProductSizeCard(
    modifier: Modifier = Modifier,
    size: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val backGroundColor = if (isSelected) {
        Color.Blue
    } else {
        Color.White
    }
    val border = if (isSelected) 0.dp else 0.8.dp
    val txtColor = if (isSelected) Color.White else Color.Black
    Text(
        text = size,
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = border, color = Color.Black,
                shape = RoundedCornerShape(12.dp)
            )
            .background(backGroundColor)
            .clickable { onClick() }
            .padding(12.dp),
        fontSize = 12.sp,
        color = txtColor
    )


}


@Composable
fun ProductColor(
    modifier: Modifier = Modifier,
    color: Color,
    isSelected: Boolean, onClick: () -> Unit

) {
    val borderColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent
    Box(
        modifier = modifier
            .border(width = 0.5.dp, shape = CircleShape, color = borderColor)
            .padding(4.dp)
            .background(color, shape = CircleShape)
            .size(24.dp)
            .clip(CircleShape)
            .clickable { onClick() }
    ) { }

}