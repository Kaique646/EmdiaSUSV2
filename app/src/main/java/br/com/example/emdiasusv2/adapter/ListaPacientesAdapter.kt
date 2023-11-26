package br.com.example.emdiasusv2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.example.emdiasusv2.R
import br.com.example.emdiasusv2.model.Paciente


class ListaPacientesAdapter (
    private val context: Context,
     pacientes : List<Paciente>
): RecyclerView.Adapter<ListaPacientesAdapter.ViewHolder>() {

    private val pacientes = pacientes.toMutableList()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        fun vincula(paciente: Paciente) {
            val nome = itemView.findViewById<TextView>(R.id.nome)
            nome.text = paciente.nome

            val email = itemView.findViewById<TextView>(R.id.email)
            email.text = paciente.email

            val cpf = itemView.findViewById<TextView>(R.id.cpf)
            cpf.text = paciente.cpf

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.paciente_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val paciente = pacientes[position]
        holder.vincula(paciente)

    }

    override fun getItemCount(): Int = pacientes.size

    fun atualiza(pacientes: List<Paciente>){
        this.pacientes.clear()
        this.pacientes.addAll(pacientes)
        notifyDataSetChanged()
    }

}
