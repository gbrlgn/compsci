package br.com.alura.loja.http;

public interface HttpAdapter {
    void post(String url, Map<String, Object> dados);
}