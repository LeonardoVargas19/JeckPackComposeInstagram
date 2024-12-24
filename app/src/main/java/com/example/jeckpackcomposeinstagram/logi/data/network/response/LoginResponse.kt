package com.example.jeckpackcomposeinstagram.logi.data.network.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(@SerializedName(value = "success") val success: Boolean)
