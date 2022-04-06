package escola;

public class MatricularAlunoCLI {
    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com";

        MatricularAluno matricular = new MatricularAluno(new RepositorioAlunosMemoria());
        matricular.executar(new MatricularAlunoDto(nome, cpf, email));
    }
}