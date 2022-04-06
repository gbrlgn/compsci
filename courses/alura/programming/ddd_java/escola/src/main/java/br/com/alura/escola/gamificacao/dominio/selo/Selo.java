package selo;

public class Selo {
    private CPF cpf;
    private String nome;

    public Selo(CPF cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public CPF getCpf() {
        return this.cpf;
    }

    public String getNome() {
        return this.nome;
    }
}