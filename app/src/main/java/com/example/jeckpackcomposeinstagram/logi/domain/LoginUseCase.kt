package com.example.jeckpackcomposeinstagram.logi.domain

import com.example.jeckpackcomposeinstagram.logi.data.LoginRepository
import javax.inject.Inject

//dominio


class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(user: String, password: String): Boolean {
        return repository.doLogin(user, password)
    }

}