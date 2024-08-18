package app.birojow.auth.presentation.login

sealed interface LoginAction {
    data object OnTogglePasswordVisibility : LoginAction
    data object OnLoginclick : LoginAction
    data object OnRegisterClick : LoginAction
}
