package br.com.fundatec.fundatecheroesti21.register.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.fundatec.fundatecheroesti21.register.domain.RegisterUseCase
import br.com.fundatec.fundatecheroesti21.register.presentation.model.RegisterViewState
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    private val registerUseCase by lazy { RegisterUseCase() }

    private val _registerViewState = MutableLiveData<RegisterViewState>()
    val registerViewState: LiveData<RegisterViewState> = _registerViewState

    fun registerUser(name: String, email: String, password: String) {
        viewModelScope.launch {
            val success = registerUseCase.register(name, email, password)
            if (success) {
                _registerViewState.value = RegisterViewState.ShowLoginScreen
            } else {
                _registerViewState.value = RegisterViewState.ShowErrorMessage
            }
        }
    }
}

