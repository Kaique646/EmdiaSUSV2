package br.com.example.emdiasusv2.ui.activity

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
        configuraBotaoSalvar()
        }
        private fun configuraBotaoSalvar() {
            val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
            val dao = PacienteDAO()
            botaoSalvar.setOnClickListener {
                val produtoNovo = criaPaciente()
                dao.adiciona(produtoNovo)
                finish()
            }
        }

    private fun criaPaciente(): Paciente {
        val campoNome = findViewById<EditText>(R.id.nome)
        val nome = campoNome.text.toString()

        val campoEmail = findViewById<EditText>(R.id.email)
        val email =campoEmail.text.toString()

        val campoCpf = findViewById<EditText>(R.id.cpf)
        val cpf = campoCpf.text.toString()

        return  Paciente(
            nome = nome,
            email = email,
            cpf = cpf
        )
    }

}