package br.com.alura.forum.repository

import br.com.alura.forum.dto.TopicoPorCategoriaDto

interface TopicoRepository: JpaRepository<Topico, Long> {
    fun findByCursoNome(
        nomeCurso: String,
        paginacao: Pageable
    ) Page<Topico>

    @Query("""
        SELECT NEW 
        br.com.alura.forum.dto.TopicoPorCategoriaDto(curso.categoria, count(t))
        FROM Topico t 
        JOIN t.curso curso
        GROUP BY curso.categoria
    """)
    fun relatorio(): List<TopicoPorCategoriaDto>
}