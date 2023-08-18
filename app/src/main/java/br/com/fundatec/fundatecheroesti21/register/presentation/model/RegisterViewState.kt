package br.com.fundatec.fundatecheroesti21.register.presentation.model

sealed class RegisterViewState {
    object ShowLoginScreen : RegisterViewState()
    object ShowErrorMessage : RegisterViewState()
    object ShowLoading : RegisterViewState()
}
