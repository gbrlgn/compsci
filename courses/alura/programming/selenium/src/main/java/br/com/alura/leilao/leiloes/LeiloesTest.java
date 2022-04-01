package br.com.alura.leilao.leiloes;

import org.junit.Assert.*;

public class LeiloesTest {
    private LeiloesPage paginaLeiloes;
    private CadastroLeilaoPage paginaCadastro;

    @BeforeEach
    public void beforeEach() {
        LoginPage paginaLogin = new LoginPage();
        paginaLogin.preencherFormulario("John Doe", "WASTE");

        this.paginaLeiloes = paginaLogin.efetuarLogin();
        
        this.paginaCadastro = paginaLeiloes.carregarFormulario();
    }

    @AfterEach
    public void afterEach() {
        this.paginaLeiloes.fechar();
    }
    
    @Test
    public void deveCadastrarLeilao() {
        String hoje = LocalDate.now()
            .format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String nome = "Leilão do dia " + hoje;
        String valor = "500.00";

        this.paginaLeiloes = paginaCadastro.cadastrarLeilao(nome, valor, hoje);
        
        Assert.assertTrue(paginaLeiloes.isCadastrado(nome, valor, hoje));
    }

    @Test
    public void deveValidarCadastro() {
        this.paginaLeiloes = paginaCadastro.cadastrarLeilao("", "", "");

        Assert.assertFalse(this.paginaCadastro.isPaginaAtual());
        
        Assert.assertTrue(this.paginaLeiloes.isPaginaAtual());
        
        Assert.assertTrue(this.paginaCadastro.isMensagemValidacaoVisivel());
    }
}