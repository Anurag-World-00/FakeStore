package com.codinghits.fakestore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.codinghits.fakestore.navigation.AppNavHost
import com.codinghits.fakestore.screens.ProductDetailScreen
import com.codinghits.fakestore.ui.theme.FakeStoreTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FakeStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                   ProductScreen()
                   AppNavHost()
                }
            }
        }
    }
}

