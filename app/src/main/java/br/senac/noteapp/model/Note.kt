package br.senac.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//Anotacao sempre antes do que será afetado
//Essa anotacao criará uma tabela na aplicacao Android no SQLite
@Entity
data class Note(
    //Gerar Id automaticamente
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title: String,
    //Mudar nome da coluna
    //@ColumnInfo(name = "Description")
    var desc: String
)
