package com.baumgartner.base.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Cesar Pereira Viana
 * @version 1.0
 * 
 * Interface que define os métodos a serem implementados pelos 
 * objetos de acesso a banco.
 * */
public interface DAO<T, I extends Serializable> {

	public T save(T entity);

	public void remove(T entity);
	
	public T getById(Class<T> classe, I pk);
	
	public List<T> getAll(Class<T> classe);

	public EntityManager getEntityManager();
}
