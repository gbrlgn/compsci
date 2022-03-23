package br.com.alura.loja.orcamento;

public class ItemOrcamento implements Orcavel {
    private BigDecimal valor;

    public ItemOrcamento(BigDecimal valor) {
        valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }
}