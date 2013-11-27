package com.baumgartner.impl.view.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import com.baumgartner.base.util.JSFUtil;
import com.baumgartner.impl.model.Usuario;
import com.baumgartner.impl.model.dao.UsuarioDAOImpl;

@ManagedBean
@ViewScoped
public class TableBean3 {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosSelecionados;

	private UsuarioDAOImpl dao;
	
	public TableBean3(){
		dao = new UsuarioDAOImpl();
	}
	
	@PostConstruct
	public void carregaDados(){
		usuarios = dao.getAll(Usuario.class);
	}
	
	public void onRowEditCancel(RowEditEvent event){
		usuariosSelecionados.removeAll(usuariosSelecionados);
		System.out.println(usuariosSelecionados.size());
	}
	
	public void test(){
		JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, String.valueOf(usuariosSelecionados.size()), null);
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public List<Usuario> getUsuariosSelecionados() {
		return usuariosSelecionados;
	}

	public void setUsuariosSelecionados(List<Usuario> usuariosSelecionados) {
		this.usuariosSelecionados = usuariosSelecionados;
	}

}