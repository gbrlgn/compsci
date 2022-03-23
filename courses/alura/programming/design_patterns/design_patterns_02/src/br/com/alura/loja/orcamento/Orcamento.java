package br.com.alura.loja.orcamento;

import java.math.BigDecimal;

import br.com.alura.loja.orcamento.Orcavel;
import br.com.alura.loja.orcamento.situacao.EmAnalise;
import br.com.alura.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
	private BigDecimal valor;
	private SituacaoOrcamento situacao;
    private List<ItemOrcamento> itens;

	public Orcamento(BigDecimal valor, int quantidadeItens) {
		this.valor = valor;
        this.itens = new ArrayList<>();
		this.situacao = new EmAnalise();
	}

	public void aplicarDescontoExtra() {
		BigDecimal valorDescontoExtra = this.situacao.calcularDescontoExtra(this);
		this.valor = this.valor.subtract(valorDescontoExtra);
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

	public BigDecimal getValor() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            throw new RuntimeException(e);
        }

		return valor;
	}

	public int getQuantidadeItens() {
		return itens.size();
	}

	public SituacaoOrcamento getSituacao() {
		return situacao;
	}

    public void adicionarItem(ItemOrcamento item) {
        this.valor = valor.add(item.getValor());
        this.itens.add(item);
    }
	
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}

    public boolean isFinalizado() {
        return situacao instanceof Finalizado;
    }
}
