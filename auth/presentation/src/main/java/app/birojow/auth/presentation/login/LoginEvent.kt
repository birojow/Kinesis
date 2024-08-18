package app.birojow.auth.presentation.login

import app.birojow.core.presentation.ui.UiText

sealed interface LoginEvent {
    data class LoginError(val error: UiText) : LoginEvent
    data object LoginSuccess : LoginEvent
}
