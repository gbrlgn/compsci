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

@Service
class TopicoService(
    private var topicos: List<Topico> = ArrayList(),
    private val topicoViewMapper: TopicoViewMapper,
    private val topicoFormMapper: TopicoFormMapper,
    private val notFoundMessage: String = "Tópico não encontrado"
) {
    init {
        val topico1 = Topico(
            1,
            "Dúvida Kotlin",
            "Variáveis",
            LocalDateTime.now(),
            Curso(
                1,
                "Kotlin",
                "Programação",
            ),
            Usuario(
                1,
                "Ana da Silva",
                "ana@email.com"
            )
        )

        val topico2 = Topico(
            2,
            "Dúvida Kotlin2",
            "Variáveis2",
            LocalDateTime.now(),
            Curso(
                1,
                "Kotlin",
                "Programação",
            ),
            Usuario(
                1,
                "Ana da Silva",
                "ana@email.com"
            )
        )

        val topico3 = Topico(
            3,
            "Dúvida Kotlin3",
            "Variáveis3",
            LocalDateTime.now(),
            Curso(
                1,
                "Kotlin",
                "Programação",
            ),
            Usuario(
                1,
                "Ana da Silva",
                "ana@email.com"
            )
        )

        topicos = Arrays.asList(topico1, topico2, topico3)
    }

    fun listar(): List<TopicoView> {
        return topicos
            .stream()
            .map { t: Topico -> topicoViewMapper.map(t) }
            .collect(Collectors.toList())
    }

    fun buscarPorId(id: Long): TopicoView {
        val topico = topicos
            .stream()
            .filter { t.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }

        return topicoViewMapper.map(topico)
    }

    fun cadastrar(
        @RequestBody form: NovoTopicoForm
    ): TopicoView {
        var topico = topicoFormMapper.map(form)
        topico.id = topicos.size.toLong() + 1
        topicos = topicos.plus(topico)
        return topicoViewMapper.map(topico)
    }

    fun atualizar(form: AtualizacaoTopicoForm): TopicoView {
        val topico = topicos
            .stream()
            .filter { t.id == form.id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }
        val topicoAtualizado = Topico(
            id = form.id,
            titulo = form.titulo,
            mensagem = form.mensagem,
            autor = topico.autor,
            curso = topico.curso,
            status = topico.status,
            respostas = topico.respostas
        )

        topicos = topico
            .minus(topico)
            .plus(topicoAtualizado)

        return topicoViewMapper.map(topicoAtualizado)
    }

    fun deletar(id: Long) {
        val topico = topicos
            .stream()
            .filter { t.id == id }
            .findFirst()
            .orElseThrow{ NotFoundException(notFoundMessage) }
        topicos = topicos.minus(topico)
    }
}