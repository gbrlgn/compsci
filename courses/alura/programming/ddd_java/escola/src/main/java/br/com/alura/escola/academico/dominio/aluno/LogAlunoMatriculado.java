package aluno;

public class LogAlunoMatriculado extends Ouvinte {
    @Override
    public void reagirAo(Evento evento) {
        String momentoFormatado = event.momento()
            .format(DateTimeFormatter.ofPattern("dd//MM//yy HH:mm"));
        System.out.println(String.format(
            "ALuno com CPF %s matriculado em: %s", 
            ((AlunoMatriculado) evento).getCpf(), 
            momentoFormatado));
    }

    @Override
    public void reagirAo(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reagirAo(evento);
        }
    }

    @Override
    protected abstract boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculado;
    }
}