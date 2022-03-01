package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Collections;

public class FraudDetectorSrv {

    public static void main(String[] args) {
        var fraudDetectorService = new FraudDetectorSrv();
        var service = new KafkaService(FraudDetectorSrv.class.getSimpleName(),
                "ECOMMERCE_NEW_ORDER", fraudDetectorService::parse);
        service.run();
    }

    private void parse(ConsumerRecord<String, String> record) {
        System.out.println("------------------------------");
        System.out.println("Processing new order; checking for fraud.");
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Order processed.");
    }

}