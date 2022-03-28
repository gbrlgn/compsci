package br.com.alura.ecommerce;

import java.util.Map;

public class ServiceProvider<T> implements Callable<Void> {
    private final ServiceProvider<T> provider;

    public ServiceRunner(ServiceFactory<T> factory) {
        this.provider = new Serviceprovider<>(factory);
    }

    public void start(int threadCount) {
        var pool = Executors.newFixedThreadPool(threadCount);
        for (int i = 0; i <= threadCount; i++) {
            pool.submit(provider);
        }
    }
}