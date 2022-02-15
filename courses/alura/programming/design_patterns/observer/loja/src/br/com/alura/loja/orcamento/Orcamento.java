package br.com.alura.loja.orcamento;

import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

import java.math.BigDecimal;

public class Orcamento {
    private BigDecimal valor;
    private int quantItens;
    private SituacaoOrcamento situacao;

    public Orcamento(BigDecimal valor, int quantItens) {
        this.valor = valor;
        this.quantItens = quantItens;
        this.situacao = new EmAnalise();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public int getQuantItens() {
        return quantItens;
    }

    public void setSitucacao(SituacaoOrcamento situacao) {
        this.situacao = situacao;
    }

    public void aplicarDescExtra() {
        BigDecimal valorDescExtra = this.situacao.calcularDescExtra(this);
        this.valor = this.valor.subtract(valorDescExtra);
    }

    public void aprovar() {
        this.situacao.aprovar(this);
    }

    public void reprovar() {
        this.situacao.reprovar(this);
    }

    public void finalizar() {
        this.situacao.finalizar(this);
    }

}
