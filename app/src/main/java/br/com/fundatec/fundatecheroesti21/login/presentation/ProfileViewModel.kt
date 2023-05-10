
    package br.com.fundatec.fundatecheroesti21.login.presentation;
    import androidx.lifecycle.LiveData
    import androidx.lifecycle.MutableLiveData
    import androidx.lifecycle.ViewModel
    import br.com.fundatec.fundatecheroesti21.login.presentation.model.ProfileViewState

    class ProfileViewModel : ViewModel (){
        private val viewState = MutableLiveData<ProfileViewState>()
        val state: LiveData<ProfileViewState> = viewState

        fun validateInputs(email: String?, password: String?) {
            viewState.value = ProfileViewState.ShowLoading
            if (email.isNullOrBlank() && password.isNullOrBlank()) {
                viewState.value = ProfileViewState.ShowErrorMessage
                return
            }

            if (email.isNullOrBlank()) {
                viewState.value = ProfileViewState.ShowEmailErrorMessage
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

            fetchLogin(email, password)
        }

        private fun fetchLogin(email: String, password: String) {
            viewState.value = ProfileViewState.ShowHomeScreen
        }

        fun isValidEmail(email: String): Boolean {
            val regex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
            return regex.matches(email)
        }

        fun validadeInputs(s: String, s1: String) {

        }
    }

