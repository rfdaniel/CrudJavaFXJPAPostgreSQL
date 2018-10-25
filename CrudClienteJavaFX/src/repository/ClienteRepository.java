package repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import factory.JPAFactory;
import model.Cidade;
import model.Cliente;

public class ClienteRepository extends Repository<Cliente> {

	public ClienteRepository(EntityManager entityManager) {
		super(entityManager);
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
