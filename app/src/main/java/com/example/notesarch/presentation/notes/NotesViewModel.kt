package com.example.notesarch.presentation.notes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesarch.domain.usecase.AddNoteUseCase
import com.example.notesarch.domain.usecase.DeleteNoteUseCase
import com.example.notesarch.domain.usecase.GetNotesUseCase
import com.example.notesarch.domain.model.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val getNotes: GetNotesUseCase,
    private val addNote: AddNoteUseCase,
    private val deleteNote: DeleteNoteUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(NotesUiState())
    val uiState: StateFlow<NotesUiState> = _uiState.asStateFlow()

    init {
        loadNotes()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            getNotes()
                .catch { e ->
                    _uiState.update { it.copy(errorMessage = e.message, isLoading = false) }
                }
                .collect { list ->
                    _uiState.update { it.copy(notes = list, isLoading = false) }
                }
        }
    }

    fun onAddNote(title: String, content: String) {
        viewModelScope.launch {
            val result = addNote(title, content)
            if (result.isFailure) {
                _uiState.update { it.copy(errorMessage = result.exceptionOrNull()?.message) }
            }
        }
    }

    fun onDeleteNote(note: Note) {
        viewModelScope.launch { deleteNote(note) }
    }

    fun clearError() {
        _uiState.update { it.copy(errorMessage = null) }
    }
}