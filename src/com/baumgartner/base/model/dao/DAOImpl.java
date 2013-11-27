package com.baumgartner.base.model.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

/**
 * Classe abstrata que implementa os métodos principais dos objetos de acesso a
 * banco.
 * 
 * @author Cesar Pereira Viana
 * @version 1.0
 * */
public abstract class DAOImpl<T, I extends Serializable> implements DAO<T, I> {

	PersistenceFactory factory;
	
	@Override
	public T save(T entity) {
		T saved = null;

		getEntityManager().getTransaction().begin();
		saved = getEntityManager().merge(entity);
		getEntityManager().getTransaction().commit();

		return saved;
	}

	@Override
	public void remove(T entity) {
		T removed = null;
		
		getEntityManager().getTransaction().begin();
		removed = getEntityManager().merge(entity);
		getEntityManager().remove(removed);
		getEntityManager().getTransaction().commit();
	}

	@Override
	public T getById(Class<T> classe, I pk) {
		try {
			return getEntityManager().find(classe, pk);
		} catch (NoResultException e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<T> classe) {
		return getEntityManager().createQuery(
				"SELECT o FROM " + classe.getSimpleName() + " o")
				.getResultList();
	}

	@Override
	public EntityManager getEntityManager() {
		if(factory == null){
			factory = new PersistenceFactory();
		}
		return factory.getEntityManager();
	}
}
