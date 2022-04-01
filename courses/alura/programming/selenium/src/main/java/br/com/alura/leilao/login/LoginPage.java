package br.com.alura.leilao.login;

import org.openqa.selenium.WebDriver;

public class LoginPage extends PageObject {
    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String  URL_LANCES = "http://localhost:8080/leiloes/2";
    private WebDriver browser;

    public LoginPage() {
        super(null);
        browser.navigate().to(URL_LOGIN);
    }

    public void preencherFormulario(String username, String password) {
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public LeiloesPage efetuarLogin() {
        browser.findElement(By.id("login-form")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isPaginaLogin() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public boolean isPaginaLoginErro() {
        return browser.getCurrentUrl().equals(URL_LOGIN + "?erro");
    }

    public Object getNomeUsuarioLogado() {
        try {
            return browser.findElement(
            By.id("usuario_logado")
            .getText());
        } catch (NoSuchElementException e) {
            return null;
        } 
    }

    public void navegaParaLances() {
        browser.navigate().to(URL_LANCES);
    }

    public boolean contemTexto(String texto) {
        return browser.getPageSource().contains(texto);
    }
}