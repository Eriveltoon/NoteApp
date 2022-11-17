package br.senac.noteapp.db

import androidx.room.*
import br.senac.noteapp.model.Note

//Utilizando Room
//Data Access Object
//Objeto de Acesso a Dados
@Dao
interface NoteDao {

    //Recebe como parametro o objeto
    //ó pode ser objeto que esteja sendo mapaeado como Entity
    //Insert Into
    @Insert
    fun inserir(note: Note)

    @Query("SELECT * FROM note")
    fun listar(): List<Note>

    /*@Delete
    fun excluir(note: Note)

    @Update
    fun atualizar(note: Note)

    @Query("SELECT * FROM Note WHERE title LIKE :titulo")
    fun pesquisar(titulo: String)*/
}