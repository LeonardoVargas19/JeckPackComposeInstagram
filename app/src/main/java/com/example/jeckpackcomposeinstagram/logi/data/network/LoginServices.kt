package com.example.jeckpackcomposeinstagram.logi.data.network

import com.example.jeckpackcomposeinstagram.core.network.RetroFitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class LoginServices {
    val retrofit = RetroFitHelper.getRetroFIt()
    suspend fun  doLogin(user :String, password: String) : Boolean{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(LoginClient::class.java).doLogin(user, password)
            response.body()?.success ?: false
        }
    }
}