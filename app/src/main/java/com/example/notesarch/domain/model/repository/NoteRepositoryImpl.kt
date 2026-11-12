package com.example.notesarch.data.repository

import com.example.notesarch.data.local.dao.NoteDao
import com.example.notesarch.data.mapper.toDomain
import com.example.notesarch.data.mapper.toEntity
import com.example.notesarch.domain.model.Note
import com.example.notesarch.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val dao: NoteDao
) : NoteRepository {

    override fun getNotes(): Flow<List<Note>> =
        dao.getAllNotes().map { list -> list.map { it.toDomain() } }

    override suspend fun insert(note: Note) = dao.insert(note.toEntity())

    override suspend fun delete(note: Note) = dao.delete(note.toEntity())
}