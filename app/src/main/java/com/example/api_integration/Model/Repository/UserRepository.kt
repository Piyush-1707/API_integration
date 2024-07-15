package com.example.api_integration.Model.Repository

import com.example.api_integration.Model.API.ApiService
import com.example.api_integration.Model.Data.User

class UserRepository(private val apiService: ApiService) {
    suspend fun getUsers(): List<User> {
        return  apiService.getUsers()
    }
}