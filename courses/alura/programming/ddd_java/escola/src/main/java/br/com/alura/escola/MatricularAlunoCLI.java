package escola;

public class MatricularAlunoCLI {
    public static void main(String[] args) {
        String nome = "Fulano";
        String cpf = "123.456.789-10";
        String email = "fulano@email.com";

        MatricularAlunoDto dto = new MatricularAlunoDto(nome, cpf, email);

        PublicadorEventos pub = new PublicadorEventos();
        pub.adicionar(new LogAlunoMatriculado());
        pub.adicionar(new GerarSeloAlunoNovato(new RepositorioSelosMemoria()));

        MatricularAluno matricular = new MatricularAluno(
            new RepositorioAlunosMemoria(), 
            pub);
    }
}