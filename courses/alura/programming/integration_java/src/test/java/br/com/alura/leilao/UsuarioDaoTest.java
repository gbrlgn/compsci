package br.com.alura.leilao.dao;

import org.junit.jupiter.apo.Assertions.*;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private EntityManager em;

    @Test
	void buscarPorUsernameTest() {
		this.dao = new UsuarioDao(em);
        Usuario usuario = this.dao.buscarPorUsername("John Doe");
        Assert.assertNotNull(usuario);
	}

	public void deletar(Usuario usuario) {
		em.remove(usuario);
	}

}
