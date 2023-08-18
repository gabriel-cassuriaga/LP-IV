package br.com.fundatec.fundatecheroesti21.splash.presentation.model

sealed class SplashViewState {
    object ShowHome : SplashViewState()
    object ShowLogin : SplashViewState()
}