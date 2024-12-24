package com.example.jeckpackcomposeinstagram.logi.data

import com.example.jeckpackcomposeinstagram.logi.data.network.LoginServices

class LoginRepository {
    private val api = LoginServices()
    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}

