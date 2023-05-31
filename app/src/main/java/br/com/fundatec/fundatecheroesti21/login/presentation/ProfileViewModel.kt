package br.com.fundatec.fundatecheroesti21.login.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState
class ProfileViewModel : ViewModel() {
    private val viewState = MutableLiveData<ProfileViewState>()
    val state: LiveData<ProfileViewState> = viewState

    fun validateInputs(name: String?, email: String?, password: String?) {
        viewState.value = ProfileViewState.ShowLoading
        if (email.isNullOrBlank() && password.isNullOrBlank() && name.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowErrorRegisterMessage
            return
        }

        if (email.isNullOrBlank() || !isValidEmail(email)) {
            viewState.value = ProfileViewState.ShowEmailErrorMessage
            return
        }

        if (password.isNullOrBlank() || password.length > 16) {
            viewState.value = ProfileViewState.ShowPasswordErrorMessage
            return
        }

        if (name.isNullOrBlank()){
            viewState.value = ProfileViewState.ShowNameErrorMessage
            return
        }



        fetchLogin(name, email, password)
    }

    private fun isValidEmail(email: String): Boolean {
        val regex = Regex("[A-Za-z\\d._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return regex.matches(email)
    }

    private fun fetchLogin(nome: String, email: String, password: String) {
        viewState.value = ProfileViewState.ShowHomeScreen
    }
}