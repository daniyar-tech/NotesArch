package com.example.notesarch.domain.usecase

import com.example.notesarch.domain.model.Note
import com.example.notesarch.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repo: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repo.delete(note)
}