package br.com.example.emdiasusv2.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.example.emdiasusv2.model.Paciente
import br.com.example.emdiasusv2.adapter.ListaPacientesAdapter
import br.com.example.emdiasusv2.R
import br.com.example.emdiasusv2.activity.ui.FormularioPacienteActivity
import br.com.example.emdiasusv2.dao.PacienteDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }

    override fun onResume() {
        super.onResume()
        setContentView(R.layout.activity_main)
        val dao = PacienteDAO()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaPacientesAdapter(context = this, pacientes = dao.buscaTodos())
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val intent = Intent(this, FormularioPacienteActivity::class.java)
            startActivity(intent)
        }
    }

}
