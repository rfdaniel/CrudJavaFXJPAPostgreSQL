package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAFactory {
	
	private JPAFactory() {
		//Garante que nunca vai ser instanciado
	}
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrudClienteJavaFX");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
