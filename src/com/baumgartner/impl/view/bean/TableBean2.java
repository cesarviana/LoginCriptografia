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
public class TableBean2 {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosSelecionados;

	private UsuarioDAOImpl dao;
	
	public TableBean2(){
		dao = new UsuarioDAOImpl();
	}
	
	@PostConstruct
	public void carregaDados(){
		usuarios = dao.getAll(Usuario.class);
	}

	public void excluir() {
		if (usuariosSelecionados == null) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO,
					"Selecione ao menos um usuário." + usuariosSelecionados.size(), null);
		} else {
			try {
				for (Usuario usuario : usuariosSelecionados) {
					dao.remove(usuario);
				}
				JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Usuários excluidos com sucesso.", null);
				usuariosSelecionados.removeAll(usuariosSelecionados);
				carregaDados();
			} catch (Exception e) {
				JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR,
						"Falha ao excluir. Contate o administrador.", null);
			}
		}
	}

	public void teste(){
		JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, String.valueOf(usuariosSelecionados.size()), null);
	}
		
	public void onRowEdit(RowEditEvent event){
		Usuario usuarioEditado = (Usuario) event.getObject();
		dao.save(usuarioEditado);
		System.out.println("EDITANDO USUÁRIO DE LOGIN = " + usuarioEditado.getLogin());
	}
	
	public void onRowEditCancel(RowEditEvent event){
		System.out.println("ROW EDIT CANCEL");
		usuariosSelecionados.removeAll(usuariosSelecionados);
		System.out.println("TAMANHO = " + usuariosSelecionados.size());
		teste();
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