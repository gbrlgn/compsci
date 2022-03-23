package br.com.alura.loja.imposto;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcamento;

public abstract class Imposto {
    private Imposto outro;

    public Imposto(Imposto outro) {
        outro = outro;
    }

    protected abstract BigDecimal realizarCalculo(Orcamento orcamento);

	public BigDecimal calcular(Orcamento orcamento) {
        BigDecimal valorImposto = realizarCalculo(orcamento);
        BigDecimal valorOutro = BigDecimal.ZERO;
        if (outro != null) {
            valorOutro = outro.realizarCalculo(orcamento);
        }
        
        return valorImposto.add(valorOutro);
    }

}
