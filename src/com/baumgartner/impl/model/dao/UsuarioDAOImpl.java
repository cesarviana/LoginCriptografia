package com.baumgartner.impl.model.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.baumgartner.base.model.dao.DAOImpl;
import com.baumgartner.impl.model.Usuario;

public class UsuarioDAOImpl extends DAOImpl<Usuario, Integer> implements
		UsuarioDAO {

	@Override
	public Usuario getUsuario(String login) {

		EntityManager em = getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
		Root<Usuario> u = c.from(Usuario.class);
		c.select(u);
		c.where(cb.equal(u.get("login"), login));
		try {
			return em.createQuery(c).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Usuario getUsuario(String login, String senha) {

		EntityManager em = getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
		Root<Usuario> u = c.from(Usuario.class);
		c.select(u);
		c.where(cb.equal(u.get("login"), login),
				cb.equal(u.get("senha"), senha));
		try {
			return em.createQuery(c).getSingleResult();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int count(String login) {

		EntityManager em = getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
		Root<Usuario> u = c.from(Usuario.class);
		c.select(u);
		c.where(cb.equal(u.get("login"), login));
		try {
			return em.createQuery(c).getResultList().size();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int count(String login, String senha) {

		EntityManager em = getEntityManager();

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> c = cb.createQuery(Usuario.class);
		Root<Usuario> u = c.from(Usuario.class);
		c.select(u);
		c.where(cb.equal(u.get("login"), login),
				cb.equal(u.get("senha"), senha));
		try {
			return em.createQuery(c).getResultList().size();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
