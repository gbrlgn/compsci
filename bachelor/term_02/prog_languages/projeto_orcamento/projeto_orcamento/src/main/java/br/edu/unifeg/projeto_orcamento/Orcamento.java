package br.edu.unifeg.projeto_orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Orcamento extends ItensOrcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int cliente_orcam;
    private String data_pagam;
    private String data_venc;
    private String comentario_nf;
    private Double total_orc;
    private String faturado;

    public void setIdOrc(int id) {
        this.id = id;
    }

    public void setCliOrc(int orc) {
        this.cliente_orcam = orc;
    }

    public void setDataPagam(String pag) {
        this.data_pagam = pag;
    }

    public void setDataVenc(String venc) {
        this.data_venc = venc;
    }

    public void setComentNf(String com) {
        this.comentario_nf = com;
    }

    public void setTotalOrc(Double total){
        this.total_orc = total;
    }

    public void setFaturado(String fat) {
        this.faturado = fat;
    }


    public int getIdOrc() {
        return this.id;
    }

    public int getClienteOrc() {
        return this.cliente_orcam;
    }

    public String getDataPag() {
        return this.data_pagam;
    }

    public String getDataVenc() {
        return this.data_venc;
    }

    public String getComentNf() {
        return this.comentario_nf;
    }

    public Double getTotalOrc() {
        return this.total_orc;
    }

    public String getFaturado() {
        return this.faturado;
    }

}
