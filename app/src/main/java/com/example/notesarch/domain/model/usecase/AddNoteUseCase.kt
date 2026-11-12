package com.example.notesarch.domain.usecase

import com.example.notesarch.domain.model.Note
import com.example.notesarch.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    private val repo: NoteRepository
) {
    suspend operator fun invoke(title: String, content: String): Result<Unit> {
        if (title.isBlank()) {
            return Result.failure(IllegalArgumentException("Заголовок обязателен"))
        }
        val note = Note(title = title.trim(), content = content.trim())
        return runCatching { repo.insert(note) }
    }
}