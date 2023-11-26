package br.com.example.emdiasusv2.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.example.emdiasusv2.model.Paciente
import br.com.example.emdiasusv2.adapter.ListaPacientesAdapter
import br.com.example.emdiasusv2.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val nome : TextView= findViewById<TextView>(R.id.nome)
//        nome.text ="cesta de frutas"
//        val email = findViewById<TextView>(R.id.email)
//        email.text = "Laranja,manga, maca"
//        val cpf = findViewById<TextView>(R.id.cpf)
//        cpf.text = "19.90"
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaPacientesAdapter(
            context = this, pacientes = listOf(
                Paciente(nome = "Kaio", "kaio@gmail.com", "123.123.123.12"),
                Paciente("Pedro", "pedro@gmail.com", "123.121.222.13")

            )
        )
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}