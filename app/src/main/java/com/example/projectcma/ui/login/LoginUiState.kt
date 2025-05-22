package com.example.projectcma.ui.login

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val emailError: String? = null,
    val passwordError: String? = null,
    val isFormValid: Boolean = false,
    val showPassword: Boolean = false,
    val loginSuccess: Boolean = false

)