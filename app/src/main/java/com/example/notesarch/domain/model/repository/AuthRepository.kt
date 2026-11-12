package com.example.notesarch.domain.repository

interface AuthRepository {
    suspend fun login(email: String, password: String): Result<Unit>
}