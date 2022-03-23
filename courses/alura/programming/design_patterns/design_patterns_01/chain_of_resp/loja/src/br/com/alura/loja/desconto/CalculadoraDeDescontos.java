package br.com.alura.loja.desconto;

import br.com.alura.loja.orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeDescontos {
    public BigDecimal calcular(Orcamento orcamento) {
        Desconto cadeia = new DescontoCincItens(
                new DescontoQuinhVal(
                        new SemDesconto()));
        return cadeia.calcular(orcamento);
    }
}
