package br.com.alura.ecommerce;

public class BatchSendMessageService {
    private final Connection conn;

    BatchSendMessageService() throws SQLException {
        String url = "jdbc:sqlite:target/users_database.db";
        connection = DriverManager.getConnection(url);
        try {
            conn.createStatement().execute("CREATE TABLE Users (" +
                    "uuid VARCHAR(200) PRIMARY KEY," +
                    "email VARCHAR(200))");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        var batchService = new BatchSendMessageService();
        try (var service = new KafkaService<>(
            BatchSendMessageService.class.getSimpleName(),
            "ECOMMERCE_SEND_MESSAGE_TO_ALL_USERS",
            batchService::parse,
            Map.of())) {
            service.run();
        }
    }

    private final KafkaDispatcher<User> userDispatcher = new KafkaDispatcher<>(BatchSendMessageService.class.getSimpleName());

    private void parse(ConsumerRecord<String, Message<String>> record) throws SQLException, ExecutionException, InterruptedException {
        System.out.println("----------------------------------------------");
        System.out.println("Processing new batch.");
        var message = record.value();
        System.out.println("Topic: " + message.getPayload());
        
        for (User user : getAllUsers()) {
            userDispatcher.sendAsync(
                message.getPayload(),
                user.getUuid(),
                new CorrelationId(BatchSendMessageService.class.getSimpleName())
                user
            );
            System.out.println("Enviado para " + user);
        }
    }

    private User[]getAllUsers() {
        var results = conn.prepareStatement("SELECT uuid FROM USERS").executeQuery();
        List<User> users = new ArrayList<>();

        while (results.next()) {
            users.add(new User(results.getString(1)));
        }

        return users;
    }
}