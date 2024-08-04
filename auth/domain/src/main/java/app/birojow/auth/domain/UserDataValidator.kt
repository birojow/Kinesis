package app.birojow.auth.domain

class UserDataValidator(
    private val patternValidator: PatternValidator
) {

    fun isValidEmail(email: String): Boolean = patternValidator.matches(email.trim())

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= MIN_PASSWORD_LENGTH
        var hasDigit = false
        var hasLowerCaseCharacter = false
        var hasUpperCaseCharacter = false
        password.forEach {
            when {
                it.isDigit() -> hasDigit = true
                it.isLowerCase() -> hasLowerCaseCharacter = true
                it.isUpperCase() -> hasUpperCaseCharacter = true
            }
        }
        return PasswordValidationState(
            hasMinLength = hasMinLength,
            hasNumber = hasDigit,
            hasLowerCaseCharacter = hasLowerCaseCharacter,
            hasUpperCaseCharacter = hasUpperCaseCharacter
        )
    }

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }
}
