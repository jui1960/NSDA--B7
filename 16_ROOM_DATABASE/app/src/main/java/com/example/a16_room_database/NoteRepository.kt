package com.example.a16_room_database

class NoteRepository(private val notedaorepo : NoteDao) {

    fun getAllNoteRepo(): List<Note>{
        return notedaorepo.getallNotes()
    }
    fun insertRepo(note: Note){
        return notedaorepo.insert(note)
    }
    fun updateRepo(note: Note){
        return notedaorepo.update(note)
    }
    fun deleteRepo(note: Note){
        return notedaorepo.delete(note)
    }
}