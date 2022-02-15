package br.edu.unifeg.projeto_orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Alteracoes extends Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_alteracao;

    public void setIdAlter(int id) {
        this.id_alteracao = id;
    }


    public int getIdAlter() {
        return this.id_alteracao;
    }

}
