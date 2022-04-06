package aplicacao;

public class GerarSeloAlunoNovato extends Ouvinte {
    private final RepositorioSelos repoSelos;

    public GerarSeloAlunoNovato(RepositorioSelos selos) {
        this.repoSelos = selos;
    }

    @Override
    protected void reagirAo(Evento evento) {
        CPF cpf = (CPF) evento.info().get("cpf");
        Selo novato = new Selo(cpf, "Novato");
        repoSelos.adicionar(novato);
    }
    
    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }
    
}