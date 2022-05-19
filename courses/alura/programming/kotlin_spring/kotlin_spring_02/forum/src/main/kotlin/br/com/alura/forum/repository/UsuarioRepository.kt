package br.com.alura.forum.repository

import br.com.alura.forum.model.Topico

interface UsuarioRepository: JpaRepository<Topico, Long> {
}