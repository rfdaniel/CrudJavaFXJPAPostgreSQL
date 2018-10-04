package repository;

import javax.persistence.EntityManager;

import model.Cliente;

public class ClienteRepository {

	private EntityManager entityManager;
	
	public ClienteRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public Cliente save(Cliente cliente) {
		return getEntityManager().merge(cliente);
	}
	
	public void remove(Cliente cliente) {
		getEntityManager().remove(cliente);
	}
}
