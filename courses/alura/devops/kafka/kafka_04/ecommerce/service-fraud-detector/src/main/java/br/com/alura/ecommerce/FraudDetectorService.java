package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FraudDetectorService implements ConsumerService<Order> {
    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();
    private final LocalDatabase database;

    FraudDetectorService() throws SQLException {
        this.database = new LocalDatabase("frauds_database");
        this.database.createIfNotExists(
            "CREATE TABLE Orders (" +
            "uuid VARCHAR(200) PRIMARY KEY" +
            "is_fraud BOOLEAN"
        );
    }

    public static void main(String[] args) {
        new ServiceRunner<>(FraudDetectorService::new).start(1);
    }

    public void parse(ConsumerRecord<String, Message<Order>> record) throws ExecutionException, InterruptedException {
        System.out.println("-------------------------------------------");
        System.out.println("Processing new order and checking for fraud");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var message = record.value();
        var order = message.getPayLoad();
        if (wasProcessed(order)) {
            System.out.println("Order " + order.getOrderId() + " was already processed.");
            return;
        }

        if(isFraud(order)) {
            database.update("INSERT INTO Orders (uuid, is_fraud)" +
            " VALUES (?, true)", order.getOrderId());

            System.out.println("Fraudulent order! " + order);
            orderDispatcher.send(
                "ECOMMERCE_ORDER_REJECTED",
                order.getEmail(),
                new CorrelationId(FraudDetectorService.class.getSimpleName()), 
                order
            );
        } else {
            database.update("INSERT INTO Orders (uuid, is_fraud)" +
            " VALUES (?, false)", order.getOrderId());

            System.out.println("Approved: " + order);
            orderDispatcher.send(
                "ECOMMERCE_ORDER_APPROVED",
                order.getEmail(),
                new CorrelationId(FraudDetectorService.class.getSimpleName()),
                order
            );
        }
    }

    private boolean isFraud(Order order) {
        return order.getAmount().compareTo(new BigDecimal("4500")) >= 0;
    }

    private boolean wasProcessed(Order order) {
        var results = database.query("SELECT uuid FROM Orders WHERE uuid = ? LIMIT 1", order.getOrderId());
        return results.next();
    }

    @Override
    public String getTopic() {
        return "ECOMMERCE_NEW_ORDER";
    }

    @Override
    Public String getConsumerGroup() {
        return FraudDetectorService.class.getSimpleName();
    }

}
