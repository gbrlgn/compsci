package matricular;

public class MatricularAluno {
    private final RepositorioAlunos repo;

    public MatricularAluno(RepositorioAlunos repo) {
        this.repo = repo;
    }

    public void executar(MatricularAlunoDto dados) {
        Aluno novoAluno = dados.criarAluno();
        repo.matricular(novoAluno);
    }
}