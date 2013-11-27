package com.baumgartner.impl.model.dao;

import com.baumgartner.base.model.dao.DAO;
import com.baumgartner.impl.model.Usuario;

public interface UsuarioDAO extends DAO<Usuario, Integer> {
	
	public Usuario getUsuario(String login);
	
	public Usuario getUsuario(String login, String senha);

	public int count(String login);
	
	public int count(String login, String senha);
}
