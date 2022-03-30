package br.com.alura.leilao.login;

import org.junit.jupiter.api.Test;

public class LoginTest {
    private WebDriverDriver browser;
    public static final String URL_LOGIN = "http://localhost:8080/login";

    @BeforeAll
    public void beforeAll() {
        System.setProperty("webdriver.firefox.driver", "/drivers/firefox");
    }
    
    @BeforeEach
    public void beforeEach() {
        this.browser = new FirefoxDriver();
        browser.navigate().to(URL_LOGIN);
    }

    @AfterEach
    public void afterEach() {
        this.browser.quit();
    }

    @Test
    public void deveEfetuarLoginValido() {
        browser.findElement(By.id("username")).sendKeys("Fulano");
        browser.findElement(By.id("password")).sendKeys("passwd");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(
            browser.getCurrentUrl()
                .equals("http://localhost:8080/login")
        );

        Assert.assertEquals(
            "Fulano",
            browser.findElement(By.id("usuario_logado"))
                .getText();
        );
    }

    @Test
    public void naoDeveEfetuarLoginInvalido() {
        browser.findElement(By.id("username")).sendKeys("Inválido");
        browser.findElement(By.id("password")).sendKeys("wrngpasswd");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(
            browser.getCurrentUrl()
                .equals(URL_LOGIN + "?error")
        );

        Assert.assertTrue(
            "Fulano",
            browser.getPageSource()
                .contains("Usuário e senha inválidos.");
        );

        Assert.assertThrows(
            NoSuchElementException.class, 
            () -> browser.findElement(By.id("usuario_logado"))
                .getText();
        );
    }

    @Test
    public void naoDeveAcessarRestritaSemLogar() {
        browser.navigate().to("http://localhost:8080/leiloes/2");

        Assert.assertTrue(
            browser.getCurrentUrl().equals(URL_LOGIN);
        );

        Assert.assertFalse(
            browser.getPageSource()
                .contains("Dados do Leilão");
        );
    }
}