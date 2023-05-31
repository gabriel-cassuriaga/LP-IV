package br.com.fundatec.fundatecheroesti21

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.fundatec.fundatecheroesti21.login.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Rule

class ProfileViewModelTest2 {
    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private val viewModel = ProfileViewModel()
    private val stateObserver: Observer<ProfileViewState> = spyk()

    @Test
    fun validateViewState_returnShowErrorEmptyFields() {
        prepareScenario()
        viewModel.validateInputs(null, null, null)

        assertEquals(viewModel.state.value, ProfileViewState.ShowLoading)
    }

    @Test
    fun callLogin_verifyIsCalledLoginDataSource()  {
        prepareScenario()
        viewModel.validateInputs("name", "email", "password")

//        assertEquals(viewModel.state.value, LoginViewState.ShowHomeScreen)
        verifySequence {
            stateObserver.onChanged(ProfileViewState.ShowLoading)
            stateObserver.onChanged(ProfileViewState.ShowHomeScreen)
        }
    }

    private fun prepareScenario() {
        viewModel.state.observeForever(stateObserver)
    }
}