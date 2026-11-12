package com.example.notesarch.di

import android.content.Context
import androidx.room.Room
import com.example.notesarch.data.local.NoteDatabase
import com.example.notesarch.data.local.dao.NoteDao
import com.example.notesarch.data.repository.AuthRepositoryImpl
import com.example.notesarch.data.repository.NoteRepositoryImpl
import com.example.notesarch.domain.repository.AuthRepository
import com.example.notesarch.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext ctx: Context): NoteDatabase =
        Room.databaseBuilder(ctx, NoteDatabase::class.java, "notes_db")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideNoteDao(db: NoteDatabase): NoteDao = db.noteDao()

    @Provides
    @Singleton
    fun provideNoteRepository(impl: NoteRepositoryImpl): NoteRepository = impl

    @Provides
    @Singleton
    fun provideAuthRepository(impl: AuthRepositoryImpl): AuthRepository = impl
}