package aluno;

public interface RepositorioSelos {
    void adicionar(Selo selo);
    List<Selo> buscarSelosPorCPF(CPF cpf);
}