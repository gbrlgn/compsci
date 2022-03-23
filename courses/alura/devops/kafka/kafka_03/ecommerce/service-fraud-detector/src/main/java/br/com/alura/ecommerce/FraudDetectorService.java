package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class FraudDetectorService {

    public static void main(String[] args) {
        var fraudService = new FraudDetectorService();
        try (var service = new KafkaService<>(FraudDetectorService.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER",
                fraudService::parse,
                Map.of())) {
            service.run();
        }
    }

    private final KafkaDispatcher<Order> orderDispatcher = new KafkaDispatcher<>();

    private void parse(ConsumerRecord<String, Message<Order>> record) throws ExecutionException, InterruptedException {
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

        if(isFraud(order)) {
            System.out.println("Fraudulent order! " + order);
            orderDispatcher.send(
                "ECOMMERCE_ORDER_REJECTED", 
                order.getEmail(),
                new CorrelationId(FraudDetectorService.class.getSimpleName()), 
                order
            );
        } else {
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

}
