package br.edu.unifeg.projeto_orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Produto extends ItensOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_produto;

    private String nome_item;
    private int qtde_est;
    private int qtde_reserv;
    private Double valor_unit;

    public void setIdProd(int id) {
        this.id_produto = id;
    }

    public void setNomeItem(String item) {
        this.nome_item = item;
    }

    public void setQtdeEst(int qtde) {
        this.qtde_est = qtde;
    }

    public void setQtdeReserv(int qtde) {
        this.qtde_reserv = qtde;
    }

    public void setValorUnit(Double valor) {
        this.valor_unit = valor;
    }


    public int getIdProd() {
        return this.id_produto;
    }

    public String getNomeItem() {
        return this.nome_item;
    }

    public int getQtdeEst() {
        return this.qtde_est;
    }

    public int getQtdeReserv() {
        return this.qtde_reserv;
    }

    public Double getValorUnit() {
        return this.valor_unit;
    }

}
