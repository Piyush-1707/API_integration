package com.example.api_integration.Model.API

import com.example.api_integration.Model.Data.Product
import com.example.api_integration.Model.Data.User
import retrofit2.http.GET

interface  ApiService {
    @GET("Products")
    suspend fun getProducts(): List<Product>
    @GET("Users")
    suspend fun getUsers():List<User>
}