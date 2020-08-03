package br.com.sorveteria.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Factory {

	private static EntityManager entityManager;
	private static EntityManagerFactory entityManagerFactory;

	public static EntityManager getConnection() {
		if (entityManager == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("sorveteria");
			entityManager = entityManagerFactory.createEntityManager();
		}
		return entityManager;
	}

}
