package in.chocoapp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory factory;

	public static Session getSession() {
		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("chocoapp-pu");
		}
		EntityManager entityManager = factory.createEntityManager();
		Session session = entityManager.unwrap(org.hibernate.Session.class);

		SessionFactory factory = session.getSessionFactory();

		return session;
	}
}
