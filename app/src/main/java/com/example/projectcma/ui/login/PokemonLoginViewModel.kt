package com.example.projectcma.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PokemonLoginViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PokemonLoginUiState())
    val uiState: StateFlow<PokemonLoginUiState> = _uiState

    fun onEmailChange(email: String) {
        val trimmed = email.trim()
        val error = when {
            trimmed.isEmpty() -> "Ingrese un correo electrónico"
            trimmed.length > 20 -> "Máximo 20 caracteres"
            !trimmed.contains("@") -> "Formato de correo inválido"
            trimmed.startsWith(" ") || trimmed.endsWith(" ") -> "No debe empezar ni terminar con espacios"
            else -> null
        }
        _uiState.value = _uiState.value.copy(email = email, emailError = error)
        validateForm()
    }

    fun onPasswordChange(password: String) {
        val trimmed = password.trim()
        val error = when {
            trimmed.isEmpty() -> "Ingrese una contraseña"
            !trimmed.any { it.isUpperCase() } -> "Debe contener una letra mayúscula"
            !trimmed.any { it.isLowerCase() } -> "Debe contener una letra minúscula"
            !trimmed.any { it.isDigit() } -> "Debe contener un número"
            trimmed.startsWith(" ") || trimmed.endsWith(" ") -> "No debe empezar ni terminar con espacios"
            else -> null
        }
        _uiState.value = _uiState.value.copy(password = password, passwordError = error)
        validateForm()
    }

    fun togglePasswordVisibility() {
        _uiState.value = _uiState.value.copy(showPassword = !_uiState.value.showPassword)
    }

    private fun validateForm() {
        val state = _uiState.value
        val isValid = state.emailError == null &&
                state.passwordError == null &&
                state.email.isNotBlank() &&
                state.password.isNotBlank()
        _uiState.value = _uiState.value.copy(isFormValid = isValid)
    }

    fun onLogin() {
        if (_uiState.value.isFormValid) {
            viewModelScope.launch {
                _uiState.value = _uiState.value.copy(loginSuccess = true)
            }
        }
    }

    fun resetLoginSuccess() {
        _uiState.value = _uiState.value.copy(loginSuccess = false)
    }

}