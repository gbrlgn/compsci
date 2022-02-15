package br.edu.unifeg.projeto_orcamento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Cliente extends Orcamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome_cliente;
    private String cpf;
    private String data_nasc;
    private String telefone;
    private String endereco;
    private String cidade;
    private String uf;
    private String referencia;
    private String sexo;

    public void setIdCli(int id) {
        this.id = id;
    }

    public void setNomeCli(String cli) {
        this.nome_cliente = cli;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNasc(String nasc) {
        this.data_nasc = nasc;
    }

    public void setTelefone(String tel) {
        this.telefone = tel;
    }

    public void setEndereco(String end) {
        this.endereco = end;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setRef(String ref) {
        this.referencia = ref;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public int getIdCLi() {
        return this.id;
    }

    public String getNomeCli() {
        return this.nome_cliente;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getDataNasc() {
        return this.data_nasc;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public String getCidade() {
        return this.cidade;
    }

    public String getUf() {
        return this.uf;
    }

    public String getRef() {
        return this.referencia;
    }

    public String getSexo() {
        return this.sexo;
    }

}
