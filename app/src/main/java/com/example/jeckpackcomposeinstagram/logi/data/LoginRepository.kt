package com.example.jeckpackcomposeinstagram.logi.data

import com.example.jeckpackcomposeinstagram.logi.data.network.LoginServices
import javax.inject.Inject

class LoginRepository @Inject constructor(private val api: LoginServices) {
    suspend fun doLogin(user: String, password: String): Boolean {
        return api.doLogin(user, password)
    }
}

