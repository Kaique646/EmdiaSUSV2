package br.com.example.emdiasusv2.dao

import br.com.example.emdiasusv2.model.Paciente

class PacienteDAO {
    fun adiciona(paciente: Paciente){
        pacientes.add(paciente)

    }
    fun buscaTodos():List<Paciente>{
       return Companion.pacientes.toList()
    }

    companion object {
        private val pacientes = mutableListOf<Paciente>()
    }
}