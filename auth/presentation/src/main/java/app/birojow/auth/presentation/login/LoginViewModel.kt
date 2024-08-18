@file:OptIn(ExperimentalFoundationApi::class)

package app.birojow.auth.presentation.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.birojow.auth.domain.AuthRepository
import app.birojow.auth.domain.UserDataValidator
import app.birojow.auth.presentation.R
import app.birojow.core.domain.util.DataError
import app.birojow.core.domain.util.Result
import app.birojow.core.presentation.ui.UiText
import app.birojow.core.presentation.ui.asUiText
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
    private val userDataValidator: UserDataValidator
) : ViewModel() {

    var state by mutableStateOf(LoginState())
        private set

    private val eventChannel = Channel<LoginEvent>()
    val events = eventChannel.receiveAsFlow()

    init {
        combine(
            state.email.textAsFlow(),
            state.password.textAsFlow()
        ) { email, password ->
            state = state.copy(
                canLogin = userDataValidator.isValidEmail(email.toString().trim()
                ) &&
                        password.isNotEmpty()
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(action: LoginAction) {
        when(action) {
            LoginAction.OnLoginclick -> login()
            LoginAction.OnTogglePasswordVisibility -> {
                state = state.copy(isPasswordVisible = !state.isPasswordVisible)
            }
            else -> Unit
        }
    }

    private fun login() {
        viewModelScope.launch {
            state = state.copy(isLoggingIn = true)
            val result = authRepository.login(
                email = state.email.text.toString().trim(),
                password = state.password.text.toString()
            )
            state = state.copy(isLoggingIn = false)

            when (result) {
                is Result.Error -> {
                    if (result.error == DataError.Network.UNAUTHORIZED) {
                        eventChannel.send(
                            LoginEvent.LoginError(
                                UiText.StringResource(R.string.error_email_password_incorrect)
                            )
                        )
                    } else {
                        eventChannel.send(
                            LoginEvent.LoginError(result.error.asUiText())
                        )
                    }
                }
                is Result.Success -> {
                    eventChannel.send(
                        LoginEvent.LoginSuccess
                    )
                }
            }
        }
    }
}
