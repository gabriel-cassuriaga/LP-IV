package br.com.fundatec.fundatecheroesti21.register.data.repository

import br.com.fundatec.fundatecheroesti21.database.FHDatabase
import br.com.fundatec.fundatecheroesti21.register.data.local.UserEntity
import br.com.fundatec.fundatecheroesti21.network.RetrofitNetworkClient
import br.com.fundatec.fundatecheroesti21.register.data.UserRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RegisterRepository {

    private val apiService: RegisterService by lazy {
        RetrofitNetworkClient.createNetworkClient().create(RegisterService::class.java)
    }

    suspend fun registerUser(name: String, email: String, password: String): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = apiService.createUser(UserRequest(name = name, email = email, password = password))
                response.isSuccessful
            } catch (exception: Exception) {
                false
            }
        }
    }
}
