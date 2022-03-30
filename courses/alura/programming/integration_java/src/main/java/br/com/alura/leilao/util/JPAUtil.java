package br.com.alura.leilao.util;

import javax.persistence.EntityManager;

public class JPAUtil {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("tests");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}