package com.baumgartner.impl.model.dao;

import org.junit.Assert;
import org.junit.Test;

import com.baumgartner.base.util.Hash;
import com.baumgartner.impl.model.Nivel;
import com.baumgartner.impl.model.Usuario;

public class UsuarioDAOImplTest {

	//@Test
	public void testSalvarUsuario() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		Usuario usuario = new Usuario();
		usuario.setLogin("login@teste");
		usuario.setSenha("1231321313131313131");
		NivelDAOImpl nivelDao = new NivelDAOImpl();
		Nivel nivel = nivelDao.getById(Nivel.class, 1);
		usuario.getNivels().add(nivel);
		dao.save(usuario);
	}
	@Test
	public void testRedefineSenha(){
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		Usuario usuario = dao.getUsuario("cesar.pviana@gmail.com");
		usuario.setSenha(Hash.MD5("123"));
		dao.save(usuario);
	}
	@Test
	public void testCountLogin() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		Assert.assertTrue(dao.count("cesar_viana@gmail.com") > 0);
	}
	@Test
	public void testCountLogin0() {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		System.out.println("TESTE = " + dao.count("naotem@gmail.com"));
		Assert.assertTrue(dao.count("naotem@gmail.com") == 0);
	}
}
