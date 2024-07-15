package com.example.api_integration.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_integration.Model.API.RetrofitClient
import com.example.api_integration.Model.Data.User
import com.example.api_integration.Model.Repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>>
        get() = _users

    private val repository = UserRepository(RetrofitClient.apiService)


    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val userList = repository.getUsers()

                _users.postValue(userList)
                println("API DATA CALLED: $userList")
            } catch (e: Exception) {
                println("Error: $e")

            }
        }
    }
    init {
        fetchUsers()
    }
}