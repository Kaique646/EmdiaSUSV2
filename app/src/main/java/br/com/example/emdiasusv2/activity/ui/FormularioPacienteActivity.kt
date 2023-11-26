package br.com.example.emdiasusv2.activity.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import br.com.example.emdiasusv2.R
import br.com.example.emdiasusv2.dao.PacienteDAO
import br.com.example.emdiasusv2.model.Paciente

class FormularioPacienteActivity : AppCompatActivity(R.layout.activity_formulario_paciente) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
                val campoNome = findViewById<EditText>(R.id.nome)
                val nome = campoNome.text.toString()

                val campoEmail = findViewById<EditText>(R.id.email)
                val email =campoEmail.text.toString()

                val campoCpf = findViewById<EditText>(R.id.cpf)
                val cpf = campoCpf.text.toString()

            val pacienteNovo = Paciente(
                nome = nome,
                email = email,
                cpf = cpf
            )

            Log.i("FormularioPaciente","onCreate:${pacienteNovo.toString()}")
            val dao = PacienteDAO()
            dao.adiciona(pacienteNovo)
            Log.i("FormularioPaciente","onCreate:${dao.buscaTodos()}")
            finish()

        }


    }

}