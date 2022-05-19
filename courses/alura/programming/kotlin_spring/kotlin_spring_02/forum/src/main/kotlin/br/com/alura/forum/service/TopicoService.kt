package br.com.alura.forum.service

import br.com.alura.forum.dto.AtualizacaoTopicoForm
import br.com.alura.forum.dto.NovoTopicoForm
import br.com.alura.forum.dto.TopicoView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.mapper.Mapper
import br.com.alura.forum.mapper.TopicoFormMapper
import br.com.alura.forum.mapper.TopicoViewMapper
import br.com.alura.forum.model.Curso
import br.com.alura.forum.model.Topico
import br.com.alura.forum.model.Usuario
import br.com.alura.forum.repository.CursoRepository
import br.com.alura.forum.repository.TopicoRepository

@Service
class TopicoService(
    private val repo: TopicoRepository,
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado",
    private val em: EntityManager
) {

    fun listar(
        nomeCurso: String?,
        paginacao: Pageable
    ): Page<TopicoView> {
        print(em)

        val topicos = if (nomeCurso == null) repo.findAll(paginacao)
            else repo.FindByCursoNome(nomeCurso, paginacao)

        return topicos
            .map { t: Topico -> topicoViewMapper.map(t) }
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = repo
            .findById(id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(
        @RequestBody form: NovoTopicoForm
    ): TopicoView {
        val topico = topicoFormMapper.map(form)
        repo.save(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        var topico = repo
            .findById(form.id)
            .orElseThrow{ NotFoundException(notFoundMessage) }

        topico.titulo = form.titulo
        topico.mensagem = form.mensagem
        return topicoViewMapper.map(topico)
    }

    fun deletar(id: Long) {
        repo.deleteById(id)
    }

    fun relatorio() {
        return repo.relatorio()
    }
}