package br.com.alura.leilao.login;

import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage pagina;

    @BeforeEach
    public void beforeEach() {
        this.pagina = new LoginPage();
    }

    @AfterEach
    public void afterEach() {
        this.pagina.fechar();
    }

    @Test
    public void deveEfetuarLoginValido() {
        pagina.preencherFormulario("Fulano", "passwd");
        pagina.efetuarLogin();

        Assert.assertFalse(pagina.isPaginaLogin());

        Assert.assertEquals(
            "Fulano",
            pagina.getNomeUsuarioLogado()
        );
    }

    @Test
    public void naoDeveEfetuarLoginInvalido() {
        pagina.preencherFormulario("Inválido", "wrngpasswd");
        pagina.efetuarLogin();

        Assert.assertTrue(pagina.isPaginaLoginErro());

        Assert.assertNull(pagina.getNomeUsuarioLogado());

        Assert.assertTrue(pagina.contemTexto("Usuário e senha inválidos."));
    }

    @Test
    public void naoDeveAcessarRestritaSemLogar() {
        pagina.navegaParaLances();

        Assert.assertTrue(pagina.isPaginaLogin());

        Assert.assertFalse(pagina.contemTexto("Dados do Leilão"));
    }
}