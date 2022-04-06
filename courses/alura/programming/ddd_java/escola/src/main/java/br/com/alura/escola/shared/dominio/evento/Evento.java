package dominio;

public interface Evento {
    LocalDateTime momento();
    TipoDeEvento tipo();
    Map<String, Object> info();
}