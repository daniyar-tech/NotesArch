package com.example.notesarch.domain.usecase

import com.example.notesarch.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repo: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<Unit> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(IllegalArgumentException("Заполните все поля"))
        }
        return repo.login(email, password)
    }
}