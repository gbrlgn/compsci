package br.com.alura.forum.service

import br.com.alura.forum.model.Curso
import br.com.alura.forum.repository.CursoRepository

@Service
class CursoService(private val repo: CursoRepository) {

    fun buscarPorId(id: Long): Curso {
        return repo.getOne(id)
    }
}
