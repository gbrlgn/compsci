package br.com.alura.leilao;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelloWorldSelenium {
    @Test
    public void hello() {
        System.setProperty("webdriver.firefox.driver", "/drivers/firefox");
        
        WebDriver browser = new FirefoxDriver();
        browser.navigate().to("http://localhost:8080/leiloes");
        browser.quit();
    }
}