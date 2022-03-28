package br.com.alura.ecommerce;

import java.util.Map;

public class ServiceProvider<T> implements Callable<Void> {
    private final ServiceFactory<T> factory;

    public ServiceProvider(ServiceFactory<T> factory) {
        this.factory = factory;
    }

    public Void call() throws Exception
    {
        var myService = factory.create();

        try (var service = new KafkaService(
            myService.getconsumerGroup(),
            myService.getTopic(),
            myService::parse,
            Map.of()
        )) {
            service.run();
        }
        return null;
    }
}