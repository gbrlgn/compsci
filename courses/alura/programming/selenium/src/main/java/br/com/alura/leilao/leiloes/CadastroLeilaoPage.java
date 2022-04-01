package br.com.alura.leilao.leiloes;

import org.openqa.selenium.WebDriver;

public class CadastroLeilaoPage extends PageObject {
    private WebDriver browser;
    private static final String URL_CADASTRO_LEILAO = "http://localhost:8080/leiloes/new";

    public CadastroLeilaoPage(WebDriver browser) {
        super(browser);
    }

    public LeiloesPage cadastrarLeilao(String nome, String valorInicial, String dataAbertura) {
        this.browser.findElement(By.id("nome")).sendKeys(nome);
        this.browser.findElement(By.id("valorInicial")).sendKeys(valorInicial);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(dataAbertura);
        this.browser.findElement(By.id("button-submit")).submit();
        return new LeiloesPage(browser);
    }

    public boolean isCadastrado(String nome, String valor, String data) {
        WebElement cadastro = this.browser.findElement(By.cssSelector("#tabela-leiloes tbody tr:last-child"));
        WebElement colunaNome = linhaDaTabela.findElement(By.cssSelector("td:nth-child(1)"));
        WebElement colunaData = linhaDaTabela.findElement(By.cssSelector("td:nth-child(2)"));
        WebElement colunaValor = linhaDaTabela.findElement(By.cssSelector("td:nth-child(3)"));

        return colunaNome.getText().equals(nome) 
            && colunaData.getText().equals(data)
            && colunaValor.getText().equals(valor);

    }

    public boolean isPaginaAtual() {
        return browser.getCurrentUrl().equals(URL_CADASTRO_LEILAO);
    }

    public boolean isMensagemValidacaoVisivel() {
        String pageSource = browser.getPageSource();
        return pageSource.contains("minimo 3 caracteres") &&
            pageSource.contains("não deve estar em branco") &&
            pageSource.contains("deve ser um valor maior de 0.1") &&
            pageSource.contains("deve ser uma data no formato dd/MM/yyyy");

    }

    public void fechar() {
        this.browser.quit();
    }
}