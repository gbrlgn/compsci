package br.com.alura.leilao.dao;

import org.junit.jupiter.apo.Assertions.*;

class LeilaoDaoTest {
    private LeilaoDao dao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach() {
        this.em = JPAUtil.getEntityManager();
        this.dao = new LeilaoDao(em);
        em.getTransaction().begin();
    }

    @AfterEach
    public void afterEach() {
        em.getTransaction().rollback();
    }

    @Test
	void deveCadastrarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();

        em.persist(usuario)

        Leilao leilao = new LeilaoBuilder()
            .comNome("Lote 49")
            .comValorInicial(new BigDecimal("70"))
            .comData(LocalDate.now())
            .comUsuario(usuario)
            .criar();

        leilao = dao.salvar(leilao);
        Leilao salvo = dao.buscarPorId(leilao.getId());
        Assert.assertNotNull(salvo);
	}

    @Test
	void deveAtualizarUmLeilao() {
        Usuario usuario = new UsuarioBuilder()
            .comNome("Oedipa Maas")
            .comEmail("oedipa@yoyodyne.com")
            .comSenha("12345678")
            .criar();

        em.persist(usuario)

        Leilao leilao = new LeilaoBuilder()
            .comNome("Lote 49")
            .comValorInicial(new BigDecimal("70"))
            .comData(LocalDate.now())
            .comUsuario(usuario)
            .criar();

        leilao = dao.salvar(leilao);
        leilao.setNome("Leilão do Lote 49");
        leilao.setValorInicial(new BigDecimal("400"));
        leilao = dao.salvar(leilao);

        Leilao salvo = dao.buscarPorId(leilao.getId());
        Assert.assertEquals("Leilão do Lote 49", salvo.getNome());
        Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());
	}
}