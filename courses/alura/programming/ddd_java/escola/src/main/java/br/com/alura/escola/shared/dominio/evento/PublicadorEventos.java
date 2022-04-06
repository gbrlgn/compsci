package aluno;

public class PublicadorEventos {
    private List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionar(Ouvinte ouvinte) {
        this.ouvintes.add(ouvinte);
    }

    public void publicar(Evento evento) {
        this.ouvintes.forEach(o -> {
            o.processar(evento);
        })
    }
}