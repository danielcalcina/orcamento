package br.com.orcamento.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("orcamento");
	EntityManager em = factory.createEntityManager();

	public void gravar(Object obj) {
		this.em.getTransaction().begin();
		this.em.persist(obj);
		commit();
	}

	public void alterar(Object obj) {
		this.em.getTransaction().begin();
		this.em.merge(obj);
		commit();
	}

	public void deletar(Object obj) {
		this.em.getTransaction().begin();
		this.em.remove(obj);
		commit();
	}

	public List<?> listar(Class<?> clazz) {
		this.em.getTransaction().begin();
		List<?> objts = new ArrayList<Object>();
		objts = em.createQuery("FROM " + clazz.getName()).getResultList();
		this.em.flush();
		this.em.close();

		return objts;
	}

	public Object buscarId(Class<?> clazz, String id) {
		this.em.getTransaction().begin();
		Object obj = new Object();
		obj = this.em.createQuery("FROM " + clazz.getName() + "E WHERE E.id = " + id);
		this.em.flush();
		this.em.close();

		return obj;
	}

	public void commit() {
		try {
			this.em.getTransaction().commit();
			this.em.flush();
			this.em.close();
		} catch (Exception e) {
			this.em.getTransaction().rollback();
			this.em.flush();
			this.em.close();
			e.printStackTrace();
		}
	}
}
