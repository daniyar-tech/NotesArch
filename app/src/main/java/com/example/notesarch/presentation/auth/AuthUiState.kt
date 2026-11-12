package com.example.notesarch.presentation.auth

import com.example.notesarch.presentation.common.UiText

data class AuthUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val isEmailValid: Boolean = false,
    val error: UiText? = null,
    val isLoggedIn: Boolean = false
)