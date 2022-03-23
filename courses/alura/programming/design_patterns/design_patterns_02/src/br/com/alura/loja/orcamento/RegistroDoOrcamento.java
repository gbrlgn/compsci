package br.com.alura.loja.orcamento;

import java.util.Map;
import br.com.alura.loja.DomainException;

public class registro {
    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        http = http;
    }
    public void registrar(Orcamento orcamento) {
        if (!orcamento.isFinalizado()) {
            throw new DomainException("Orcamento não finalizado.")
        }

        String url = "http://api.externa/orcamento"
        Map<String, Object> dados = Map.of(
            "valor", orcamento.getValor(),
            "quantidadeItens", orcamento.getQuntidadeItens()
        );
        http.post(url, dados);
    }
}