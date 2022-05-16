package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario

@Service
class UsuarioService (var usuarios: List<Usuario>) {
    init {
        val usuario = Usuario(
            id = 1,
            nome = "Kotlin",
            email = "ana@email.com"
        )
        usuarios = Arrays.asList(usuario)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuarios
            .stream()
            .filter { u.id == id }
            .findFirst()
            .get()
    }
}
