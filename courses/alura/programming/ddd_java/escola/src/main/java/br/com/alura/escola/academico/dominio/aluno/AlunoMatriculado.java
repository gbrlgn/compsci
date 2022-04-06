package aluno;

public class AlunoMatriculado implements Evento {
    private final CPF cpf;
    private final LocalDateTime momento;

    public AlunoMatriculado(CPF cpf) {
        this.cpf = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> info() {
        return Map.of("cpf", this.cpf);
    }

    public CPF getCpf() {
        return this.cpf;
    }
}