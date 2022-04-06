package matricular;

class MatricularAlunoTest {
    @Test
    void alunoDeveSerPersistido () {
        RepositorioAlunosMemoria repo = new RepositorioAlunosMemoria();
        MatricularAluno useCase = new MatricularAluno(repo);

        MatricularAlunoDto dados = new MatricularAlunoDto("Fulano", "123.456.789-10", "fulano@email.com");
        useCase.executar(dados);

        Aluno encontrado = repositorio.buscarPorCpf(new CPF("123.456.789-10"));

        assertEquals("Fulano", encontrado.getNome());
        assertEquals("123.456.789-10", encontrado.getCpf());
        assertEquals("fulano@email.com", encontrado.getEmail());
    }
}