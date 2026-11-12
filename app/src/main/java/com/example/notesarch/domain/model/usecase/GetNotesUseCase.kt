package com.example.notesarch.domain.usecase

import com.example.notesarch.domain.model.Note
import com.example.notesarch.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repo: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> = repo.getNotes()
}