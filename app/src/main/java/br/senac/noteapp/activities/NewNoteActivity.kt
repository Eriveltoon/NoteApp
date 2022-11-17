package br.senac.noteapp.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import br.senac.noteapp.databinding.ActivityListNotesBinding
import br.senac.noteapp.databinding.ActivityNewNoteBinding
import br.senac.noteapp.db.Database
import br.senac.noteapp.model.Note

class NewNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNewNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            inserirNota()
        }
    }

    fun inserirNota(){
        //1 - Criar uma instancia do Room
        //É sempre o msm comando, só muda classe e o name
        val db = Room.databaseBuilder(this, Database::class.java, "notes").build()

        //2 - Carregar os parametros (se tiver)
        //Parametros vindo do Usuario digitado na tela
        val title = binding.etTitle.text.toString()
        val desc = binding.etDesc.text.toString()

        val nota = Note(title = title, desc = desc)

        //3 - Obter e executar a funcao do DAO
        //Necessita de Thread (Roda em uma linha paralela para nao travar a atividade principal)
        //Toda vez que rodar um comando que estiver no DAO tem que estar dentro de uma Thread
        Thread{
            db.noteDao().inserir(nota)
            finish()
        }.start()
    }
}