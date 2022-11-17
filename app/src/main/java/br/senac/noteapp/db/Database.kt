package br.senac.noteapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.senac.noteapp.model.Note

//Dentro do Database ter uma funcao para cada DAO
//Database tem que ser abstrata e herdar de RoomDatabase
//No Database passar quais Entity fazem parte desse banco e versao
@Database(entities = arrayOf(Note::class), version = 1)
abstract class Database : RoomDatabase(){
    abstract fun noteDao(): NoteDao
}