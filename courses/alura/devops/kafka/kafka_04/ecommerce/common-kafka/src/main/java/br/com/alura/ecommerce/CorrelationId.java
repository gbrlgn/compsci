package br.com.alura.ecommerce;

public class CorrelationId {
    private final String id;

    CorrelationId(String title) {
        id = title + "(" + UUID.randomUUID().toString() + ")";
    }

    @Override
    public String toString() {
        return "CorrelationID(" +
        "id='" + id + "\'}";
    }

    public CorrelationID getId() {
        return id;
    }
}