package aluno;

public abstract class Ouvinte {
    protected abstract void reagirAo(Evento evento);

    protected abstract boolean deveProcessar(Evento evento);

    public void processar(Evento evento) {
        if (this.deveProcessar(evento)) {
            this.reagirAo(evento);
        }
    }

}