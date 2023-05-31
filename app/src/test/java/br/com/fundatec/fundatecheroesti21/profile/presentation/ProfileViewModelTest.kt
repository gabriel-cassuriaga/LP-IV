package br.com.fundatec.fundatecheroesti21.profile.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import br.com.fundatec.fundatecheroesti21.login.presentation.ProfileViewModel
import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState
import io.mockk.spyk
import io.mockk.verifySequence
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ProfileViewModelTest {

    @get:Rule
    val instantTask = InstantTaskExecutorRule()

    private val viewModel: ProfileViewModel = ProfileViewModel()
    private val stateObserver: Observer<ProfileViewState> = spyk()

    @Test
    fun validate_inputs_when_null() {
        viewModel.validateInputs(null, null, null)

        assertEquals(viewModel.state.value, ProfileViewState.ShowErrorRegisterMessage)
    }

    @Test
    fun validate_sequenceViewState_inputs_when_null() {
        prepareScenario()
        viewModel.validateInputs(null, null, null)

        verifySequence {
            stateObserver.onChanged(ProfileViewState.ShowLoading)
            stateObserver.onChanged(ProfileViewState.ShowErrorRegisterMessage)
        }
    }

    @Test
    fun validate_inputs_when_not_null() {
        viewModel.validateInputs("john", "test@gmail.com", "123456")

        assertEquals(viewModel.state.value, ProfileViewState.ShowErrorRegisterMessage)
    }

    @Test
    fun validate_inputs_password_length(){
        viewModel.validateInputs("john", "test@gmail.com", "12345678910111213141516")

        assertEquals(viewModel.state.value, ProfileViewState.ShowErrorRegisterMessage)
    }

    private fun prepareScenario() {
        viewModel.state.observeForever(stateObserver)
    }

}