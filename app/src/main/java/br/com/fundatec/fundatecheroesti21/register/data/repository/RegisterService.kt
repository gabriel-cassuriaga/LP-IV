package br.com.fundatec.fundatecheroesti21.register.data.repository

import br.com.fundatec.fundatecheroesti21.register.data.remote.RegisterResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterService {

    @FormUrlEncoded
    @POST("/api/register")
    suspend fun insertUser(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<RegisterResponse>
}
