package br.com.fundatec.fundatecheroesti21.register.domain

import br.com.fundatec.fundatecheroesti21.register.data.repository.RegisterRepository

class RegisterUseCase {
    private val repository by lazy { RegisterRepository() }

    suspend fun register(name: String, email: String, password: String): Boolean {

        return repository.registerUser(name, email, password)
    }
}
