package br.com.fundatec.fundatecheroesti21.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.home.view.HomeActivity
import br.com.fundatec.fundatecheroesti21.login.view.LoginActivity
import br.com.fundatec.fundatecheroesti21.splash.presentation.SplashViewModel
import br.com.fundatec.fundatecheroesti21.splash.presentation.model.SplashViewState

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        viewModel.state.observe(this) { viewState ->
            when (viewState) {
                SplashViewState.ShowHome -> showHome()
                SplashViewState.ShowLogin -> showLogin()
            }
        }
    }

    private fun showHome() {
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        finish()
    }

    private fun showLogin() {
        startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
        finish()
    }
}