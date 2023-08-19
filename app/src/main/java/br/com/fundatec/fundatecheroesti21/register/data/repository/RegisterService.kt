package br.com.fundatec.fundatecheroesti21.register.data.repository

import br.com.fundatec.fundatecheroesti21.register.data.UserRequest
import br.com.fundatec.fundatecheroesti21.register.data.remote.RegisterResponse
import retrofit2.Response
import retrofit2.http.*

interface RegisterService {
    @POST("/api/login")
    suspend fun createUser(
        @Body userRequest: UserRequest,
    ): Response<RegisterResponse>

}
