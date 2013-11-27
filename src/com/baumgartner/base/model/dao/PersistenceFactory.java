package com.baumgartner.base.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Classe para gerar uma instância de EntityManager.
 * 
 * @author Cesar Pereira Viana
 * @version 1.0
 * */
public class PersistenceFactory {

	static EntityManager em;
	
	public PersistenceFactory() {
		em = Persistence.createEntityManagerFactory("LoginCriptografia").createEntityManager();
	}
	public EntityManager getEntityManager() {
		return em;
	}

}
