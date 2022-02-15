package br.edu.unifeg.projeto_orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class ItensOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int item;
    private int qtde_item;
    private Double valor;

    public void setIdItem(int id) {
        this.id = id;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setQtdeItem(int qtde) {
        this.qtde_item = qtde;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public int getIdItem() {
        return this.id;
    }

    public int getItem() {
        return this.item;
    }

    public int getQtdeItem() {
        return this.qtde_item;
    }

    public Double getValorItem() {
        return this.valor;
    }

}
