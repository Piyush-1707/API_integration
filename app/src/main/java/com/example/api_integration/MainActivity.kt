package com.example.api_integration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.api_integration.ViewModel.ProductViewModel
import com.example.api_integration.ViewModel.UserViewModel
import com.example.api_integration.Views.ProductScreen
import com.example.api_integration.ui.theme.API_integrationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            val productVM: ProductViewModel by viewModels()
            val userVM: UserViewModel by viewModels()
            API_integrationTheme {
                ProductScreen(productVM = productVM)
                //userScreen(userVM = userVM)
            }
        }
    }
}
