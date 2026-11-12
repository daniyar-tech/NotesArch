package com.example.notesarch.data.repository

import com.example.notesarch.domain.repository.AuthRepository
import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor() : AuthRepository {
    override suspend fun login(email: String, password: String): Result<Unit> {
        delay(1500) // имитация сети
        return if (email == "test@test.ru" && password == "123456") {
            Result.success(Unit)
        } else {
            Result.failure(Exception("Неверный email или пароль"))
        }
    }
}