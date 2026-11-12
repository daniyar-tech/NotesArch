package com.example.notesarch.data.mapper

import com.example.notesarch.data.local.entity.NoteEntity
import com.example.notesarch.domain.model.Note

fun NoteEntity.toDomain(): Note = Note(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp
)

fun Note.toEntity(): NoteEntity = NoteEntity(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp
)