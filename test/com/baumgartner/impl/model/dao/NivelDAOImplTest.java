package com.baumgartner.impl.model.dao;

import org.junit.Assert;
import org.junit.Test;

import com.baumgartner.impl.model.Nivel;

public class NivelDAOImplTest {

	@Test
	public void testGetById() {
		NivelDAOImpl dao = new NivelDAOImpl();
		Nivel n = dao.getById(Nivel.class, 1);
		Assert.assertTrue(n.getNmNivel().equals("admin"));
	}
}
