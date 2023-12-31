package br.com.example.emdiasusv2.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.example.emdiasusv2.adapter.ListaPacientesAdapter
import br.com.example.emdiasusv2.R
import br.com.example.emdiasusv2.dao.PacienteDAO
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaPacientesActivity : AppCompatActivity( R.layout.activity_lista_pacientes){
    private val dao = PacienteDAO()
    private val adapter = ListaPacientesAdapter(context = this, pacientes = dao.buscaTodos())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecyclerView()
        configuraFab()

        }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }
    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioPacienteActivity::class.java)
        startActivity(intent)
    }


    private fun configuraRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

}
