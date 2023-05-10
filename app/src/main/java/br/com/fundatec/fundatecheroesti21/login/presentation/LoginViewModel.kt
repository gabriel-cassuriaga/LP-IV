package br.com.fundatec.fundatecheroesti21.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.LoginViewState

class LoginViewModel : ViewModel() {
    private val viewState = MutableLiveData<LoginViewState>()
    val state: LiveData<LoginViewState> = viewState

    fun validateInputs(email: String?, password: String?) {
        viewState.value = LoginViewState.ShowLoading
        if (email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = LoginViewState.ShowErrorMessage
            return
        }

        if (email.isNullOrBlank() || !isValidEmail(email)) {
            viewState.value = LoginViewState.ShowEmailErrorMessage
            return
        }

        if (password.isNullOrBlank() || password.length > 16) {
            viewState.value = LoginViewState.ShowPasswordErrorMessage
            return
        }

        fetchLogin(email, password)
    }

    private fun isValidEmail(email: String): Boolean {
        val regex = Regex("[A-Za-z\\d._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return regex.matches(email)
    }

    private fun fetchLogin(email: String, password: String) {
        viewState.value = LoginViewState.ShowHomeScreen
    }

    fun validadeInputs(s: String, s1: String) {

    }
}