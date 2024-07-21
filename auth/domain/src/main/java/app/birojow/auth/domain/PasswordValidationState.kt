package app.birojow.auth.domain

data class PasswordValidationState(
    val hasMinLength: Boolean = false,
    val hasNumber: Boolean = false,
    val hasLowerCaseCharacter: Boolean = false,
    val hasUpperCaseCharacter: Boolean = false
) {
    val isValidPassword: Boolean
        get() = hasNumber && hasMinLength && hasUpperCaseCharacter && hasLowerCaseCharacter
}
