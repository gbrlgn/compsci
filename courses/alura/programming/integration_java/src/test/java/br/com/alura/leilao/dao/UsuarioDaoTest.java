package br.com.alura.leilao.dao;

import org.junit.jupiter.apo.Assertions.*;

class UsuarioDaoTest {
    private UsuarioDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new UsuarioDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
	void deveEncontrarUsuarioCadastrado() {
        Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();

        Usuario encontrado = this.dao.buscarPorUsername(usuario.getNome());
        Assert.assertNotNull(encontrado);
	}

    @Test
	void naoDeveEncontrarUsuarioNaoCadastrado() {
        Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();

        Assert.assertThrows(
            NoResultException.class, 
            () -> this.dao.buscarPorUsername("Metzger")
        );
	}

    @Test
	void deveDeletarUsuario() {
		Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();

        dao.deletar(usuario);

        Assert.assertThrows(
            NoResultException.class, 
            () -> this.dao.buscarPorUsername(usuario.getNome())
        );
	}

    private Usuario criarUsuario() {
        Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();
        em.persist(usuario);
        return usuario;
    }
}
