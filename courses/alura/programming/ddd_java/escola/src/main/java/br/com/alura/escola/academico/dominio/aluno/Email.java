package aluno;

public class Email {
    private String endereco;

    public Email(String endereco) {
        if (endereco == null || 
            !endereco.matches("^[a-zA-Z0-9._]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")
        ) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("E-mail inválido.");
        }
    }

    public String getEndereco() {
        return this.endereco;
    }

}