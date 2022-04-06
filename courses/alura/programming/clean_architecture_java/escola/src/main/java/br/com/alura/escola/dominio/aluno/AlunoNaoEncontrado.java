package aluno;

public class AlunoNaoEncontrado extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontrado(CPF cpf) {
        super("Aluno com CPF " + cpf.getNumero() + " não encontrado.");
    }
}