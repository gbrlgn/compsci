package br.com.alura.forum.model

@Entity
data class Curso(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val nome: String,
    val categoria: String
)


