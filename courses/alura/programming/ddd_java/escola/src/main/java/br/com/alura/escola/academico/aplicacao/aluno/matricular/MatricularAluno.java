package matricular;

public class MatricularAluno {
    private final RepositorioAlunos repo;
    private final PublicadorEventos pub;

    public MatricularAluno(RepositorioAlunos repo, PublicadorEventos pub) {
        this.repo = repo;
        this.pub = pub;
    }

    public void executar(MatricularAlunoDto dados) {
        Aluno novoAluno = dados.criarAluno();
        repo.matricular(novoAluno);
        
        AlunoMatriculado evento = new AlunoMatriculado(novo.getCpf());
        pub.publicar(evento);
    }
}