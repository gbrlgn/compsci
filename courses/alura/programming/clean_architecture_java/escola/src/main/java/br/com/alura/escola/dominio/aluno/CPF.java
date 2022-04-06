package aluno;

public class CPF {
    private String cpf;

    public CPF(String cpf) {
        if (cpf == null ||
            !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
                throw new IllegalArgumentException("CPF inválido.");
        } else {
            this.cpf = cpf;
        }
    }

    public String getNumero() {
        return this.cpf;
    }
}