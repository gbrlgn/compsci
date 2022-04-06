package aluno;

public class FabricaAluno {
    private Aluno aluno;

    public FabricaAluno comNomeCPFEEmail(String nome, String cpf, String email) {
        this.aluno = new Aluno(
            new CPF(cpf), nome, new Email(email));
        return this;
    }

    public FabricaAluno comTelefone(String ddd, String numero) {
        this.aluno.adicionarTelefone(ddd, numero);
        return this;
    }

    public Aluno criar() {
        return this.aluno;
    }
}