package aluno;

public interface RepositorioSelosMemoria {
    @Override
    void adicionar(Selo selo) {
        this.selos.add(selo);
    }
    
    @Override
    List<Selo> buscarSelosPorCPF(CPF cpf) {
        return this.selos.stream()
            .filter(s -> s.getCpf().equals(cpf))
            .collect(Collector.toList());
    }
}