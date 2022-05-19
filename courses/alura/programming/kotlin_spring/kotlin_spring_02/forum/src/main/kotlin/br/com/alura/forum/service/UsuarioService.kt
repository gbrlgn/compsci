package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.UsuarioRepository

@Service
class UsuarioService (private val repo: UsuarioRepository) {

    fun buscarPorId(id: Long): Usuario {
        return repo.getOne(id)
    }
}
