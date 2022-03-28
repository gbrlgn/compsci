package br.com.alura.ecommerce;

public class Message {
    private final CorrelationId id;
    private final T payload;

    public Message(CorrelationId id, T payload) {
        this.id = id;
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "Message(" +
        "id=" + id + 
        ", payload=" + payload +
        "}";
    }

    public T getPayload() {
        return payload;
    }
}