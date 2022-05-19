package br.com.alura.forum.dto

data class AtualizacaoTopicoForm(
   @field:NotNull
   val id: Long,
   @field:NotEmpty
   @field:Size(min = 5, max = 100)
   val titulo: String,
   @field:NotEmpty
   val mensagem: String
)
