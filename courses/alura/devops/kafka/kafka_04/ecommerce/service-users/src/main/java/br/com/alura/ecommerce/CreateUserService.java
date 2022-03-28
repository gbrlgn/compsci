package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class CreateUserService implements ServiceProvider {
    private LocalDatabase database;

    CreateUserService() {
        this.database = new LocalDatabase("users_database");
        this.database.createIfNotExists(
            "CREATE TABLE Users (" +
            "uuid VARCHAR(200) PRIMARY KEY" +
            "email VARCHAR(200))"
        );
    }

    public static void main(String[] args) throws SQLException, ExecutionException, InterruptedException {
        new ServiceRunner<>(CreateUserService::new);
    }

    @Override
    public String getConsumerGroup() {
        return CreateUserService.class.getSimpleName();
    }

    @Override
    public String getTopic() {
        return "ECOMMERCE_NEW_ORDER";
    }

    private void parse(ConsumerRecord<String, Message<Order>> record) throws SQLException {
        System.out.println("----------------------------------------------");
        System.out.println("Processing new order and checking for new user");
        System.out.println(record.value());
        var order = record.value().getPayLoad();
        if(isNewUser(order.getEmail())) {
            insertNewUser(order.getEmail());
        }
    }

    private void insertNewUser(String email) throws SQLException {
        var uuid = UUID.randomUUID().toString();
        database.update("INSERT INTO Users (uuid, email) " +
        "VALUES (?, ?)");
      
        System.out.println("Usuário " + uuid + " e " + email + " adicionado.");
    }

    private boolean isNewUser(String email) throws SQLException {
        var results = database.query("SELECT uuid FROM Users " +
        "WHERE email = ? LIMIT 1");
        return !results.next();
    }
}
