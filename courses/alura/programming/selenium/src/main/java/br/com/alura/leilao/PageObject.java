package br.com.alura.leilao;

public class PageObject {
    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.firefox.driver", "/drivers/firefox");
        
        if (browser == null) {
            this.browser = new FirefoxDriver;
        } else {
            this.browser = browser;
        }

        this.browser.manage().timeouts()
            .implicitlyWait(5, TimeUnit.SECONDS);
            .pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void fechar() {
        this.browser.quit();
    }

}