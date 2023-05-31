package br.com.fundatec.fundatecheroesti21.login.presentation.model

sealed class ProfileViewState {
    object ShowEmailErrorMessage : ProfileViewState()
    object ShowPasswordErrorMessage : ProfileViewState()
    object ShowNameErrorMessage : ProfileViewState()
    object ShowErrorRegisterMessage : ProfileViewState()
    object ShowHomeScreen : ProfileViewState()
    object ShowLoading : ProfileViewState()
}
