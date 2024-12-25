package com.example.jeckpackcomposeinstagram.logi.domain

import com.example.jeckpackcomposeinstagram.logi.data.LoginRepository

class LoginUseCase {
    private val repository = LoginRepository()
    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}