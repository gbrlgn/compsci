package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Map;

public interface ConsumerService<T> {
    void parse(ConsumerRecord<String, Message<T>> record);
    String getConsumerGroup();
    String getTopic();
}