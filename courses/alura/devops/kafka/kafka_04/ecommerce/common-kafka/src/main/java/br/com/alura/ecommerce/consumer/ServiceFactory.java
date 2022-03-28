package br.com.alura.ecommerce;

import java.util.Map;

public interface ServiceFactory<T> {
    ConsumerService<T> create() throws Exception;
}