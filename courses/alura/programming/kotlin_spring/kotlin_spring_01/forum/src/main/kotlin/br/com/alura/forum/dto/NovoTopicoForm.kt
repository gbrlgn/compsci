package br.com.alura.forum.dto

data class NovoTopicoForm(
    @field:NotEmpty(message = "Título não deve estar em branco.")
    @field:Size(
        min = 5,
        max = 100,
        message = "Título deve ter entre 5 e 100 caracteres."
    )
    val titulo: String,
    @field:NotEmpty(message = "Mensagem não deve estar em branco.")
    val mensagem: String,
    @field:NotNull
    val idCurso: Long,
    @field:NotNull
    val idAutor: Long
)
