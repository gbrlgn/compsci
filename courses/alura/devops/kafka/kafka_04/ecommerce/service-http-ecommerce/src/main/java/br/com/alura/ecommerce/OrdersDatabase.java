package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class OrdersDatabase implements ConsumerService<Order>, Closeable {
    private final LocalDatabase database;

    OrdersDatabase() throws SQLException {
        this.database = new LocalDatabase("frauds_database");
        this.database.createIfNotExists(
            "CREATE TABLE Orders (" +
            "uuid VARCHAR(200) PRIMARY KEY"
        );
    }

    public boolean saveNew(Order order) throws SQLException {
        if (wasProcessed(order)) {
            return false;
        }

        database.update(
            "INSERT INTO Orders (uuid) VALUES (?)", order.getOrderId());
        return true;
    }

    public boolean wasProcessed(Order order) throws SQLException {
        var results = database.update(
            "SELECT uuid FROM Orders WHERE uuid = ? LIMIT 1", 
            order.getOrderId());
        return results.next();
    }

    @Override
    public void close() throws IOException {
        try {
            database.close();
        } catch (SQLException e) {
            throw new IOException(e);
        }
        
    }
}