package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import factory.JPAFactory;
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
		cliente = getEntityManager().merge(cliente);
		getEntityManager().remove(cliente);
	}
	
	public List<Cliente> getClientes(String nome){
		Query query = getEntityManager().createQuery("SELECT c FROM Cliente c WHERE lower(c.nome) like lower(:nome)");
		query.setParameter("nome", "%" + nome + "%");
		
		List<Cliente> lista = query.getResultList();
		
		if(lista == null) {
			lista = new ArrayList<Cliente>();
		}
		return lista;
	}
}
