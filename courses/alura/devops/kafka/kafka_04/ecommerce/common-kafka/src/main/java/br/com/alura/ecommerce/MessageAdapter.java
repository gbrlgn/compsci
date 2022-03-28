package br.com.alura.ecommerce;

public class MessageAdapter implements JsonSerializer<Message>, JsonDeserializer<MEssage> {
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext context) {
        JsonObject obj = new JsonObject();

        obj.addProperty(
            "type", 
            message.getPayload().getClass().getName()
        );

        obj.add("payload", context.serialize(message.getPayload()));
        obj.add("correlationId", context.serialize(message.getPayload(getId())));
        return obj;
    }

    @Override
    public JsonElement deserialize(JsonElement element, Type type, JsonDeserializationContext context) throws JsonParseException {
        var obj = element.getAsJsonObject();
        var payloadType = obj.get("type").getAsString();
        var id = (CorrelationId) context.deserialize(obj.get("correlationId"), CorrelationId.class);
        try {
            var payload = context.deserialize(obj.get("payload"), Class.forName(payloadType));
            return new Message(correlationId, payload)
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e);
        }
    }
}