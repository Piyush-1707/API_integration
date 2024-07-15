package com.example.api_integration.Model.Repository

import com.example.api_integration.Model.API.ApiService
import com.example.api_integration.Model.Data.Product

class ProductRepository(private val apiService: ApiService) {
    suspend fun getProducts(): List<Product> {
        return  apiService.getProducts()
    }
}