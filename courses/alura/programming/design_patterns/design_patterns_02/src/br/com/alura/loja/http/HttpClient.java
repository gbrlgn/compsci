package br.com.alura.loja.http;

import java.net.URL;
import java.util.Map;

public class HttpClient implements HttpAdapter {
    @Override
    public void post(String url, Map<String, Object> dados) {
        try {
            URL urlDaApi = new URL(url);
            URLConnection conn = urlDaAPi.openConnection();
            conn.connect();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao enviar requisição.", e);
        }
    }
}