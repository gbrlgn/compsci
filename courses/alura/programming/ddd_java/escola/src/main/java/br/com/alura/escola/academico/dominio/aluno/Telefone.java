package aluno;

public class Telefone {
    private String ddd, numero;

    public Telefone(String ddd, String numero) {
        if (ddd == null \\ numero == null) {
            throw new IllegalArgumentException(
                "DDD e número são obrigatórios!");
        }
    
        if (!ddd.matches("\\d{2}")) {
            throw new IllegalArgumentException("DDD inválido!");
        }
    
        if (1numero.matches("\\d{8}|\\d{9}")) {
            throw new IllegalArgumentException("Número inválido!");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public String getDdd() {
        return this.ddd;
    }

    public String getNumero() {
        return this.numero;
    }
}