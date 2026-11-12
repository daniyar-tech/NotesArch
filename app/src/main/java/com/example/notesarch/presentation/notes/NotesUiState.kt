package com.example.notesarch.presentation.notes

import com.example.notesarch.domain.model.Note

data class NotesUiState(
    val isLoading: Boolean = false,
    val notes: List<Note> = emptyList(),
    val errorMessage: String? = null
)