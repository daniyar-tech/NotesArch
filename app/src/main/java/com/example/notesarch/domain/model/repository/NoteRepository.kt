package com.example.notesarch.domain.repository

import com.example.notesarch.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun insert(note: Note)
    suspend fun delete(note: Note)
}