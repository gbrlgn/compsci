package matricular;

public class MatricularAlunoDto {
    private String nomeAluno, cpfAluno, emailAluno;

    public MatricularAluno(String nome, String cpf, String email) {
        this.nomeAluno = nome;
        this.cpfAluno = cpf;
        this.emailAluno = email;
    }

    public Aluno criarAluno() {
        return new Aluno(new CPF(cpfAluno), nomeAluno, new Email(emailAluno));
    }
}