package br.com.fundatec.fundatecheroesti21.register.data.remote

import com.squareup.moshi.JsonClass
@JsonClass(generateAdapter = true)
data class RegisterResponse(
    val id: Int,
    val name: String,
    val email: String,
    val password: String
)
