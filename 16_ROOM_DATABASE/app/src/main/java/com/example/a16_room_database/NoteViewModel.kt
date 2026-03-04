package com.example.a16_room_database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: NoteRepository

    val liveData = MutableLiveData<List<Note>>()

    init {
        val dao = AppDatabse.getdatabse(application).notedao()
        repository = NoteRepository(dao)
        loadnoteviewModel()
    }

    fun loadnoteviewModel() {
        liveData.value = repository.getAllNoteRepo()

    }


    fun insertview(note: Note) {
        repository.insertRepo(note)
        loadnoteviewModel()
    }


    fun updatertview(note: Note) {
        repository.updateRepo(note)
        loadnoteviewModel()
    }

    fun deleteview(note: Note) {
        repository.deleteRepo(note)
        loadnoteviewModel()
    }
}