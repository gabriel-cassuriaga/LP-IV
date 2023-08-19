package br.com.fundatec.fundatecheroesti21.register

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fundatec.core.hide
import br.com.fundatec.core.show
import br.com.fundatec.fundatecheroesti21.R
import br.com.fundatec.fundatecheroesti21.databinding.ActivityRegisterBinding
import br.com.fundatec.fundatecheroesti21.register.presentation.RegisterViewModel
import br.com.fundatec.fundatecheroesti21.register.presentation.model.RegisterViewState
import com.google.android.material.snackbar.Snackbar
import br.com.fundatec.fundatecheroesti21.login.view.LoginActivity

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeObserver()

        binding.btCadastrar.setOnClickListener {
            val name = binding.cadastroNome.text.toString()
            val email = binding.cadastroEmail.text.toString()
            val password = binding.cadastroPwd.text.toString()

            viewModel.registerUser(name, email, password)
        }
    }

    private fun initializeObserver() {
        viewModel.registerViewState.observe(this) { viewState ->
            when (viewState) {
                RegisterViewState.ShowErrorMessage -> showSnackError()
                RegisterViewState.ShowLoading -> showLoading()
                RegisterViewState.ShowLoginScreen -> showLogin()
            }
        }
    }

    private fun showLoading() {
        binding.pbCadastroLoading.show()
    }


    private fun showSnackError() {
        binding.pbCadastroLoading.hide()
        Snackbar.make(binding.root, R.string.register_error_message, Snackbar.LENGTH_LONG).show()
    }

    private fun showLogin() {
        binding.pbCadastroLoading.hide()
        finish()
    }
}
