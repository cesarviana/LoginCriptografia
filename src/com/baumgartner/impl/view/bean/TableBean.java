package com.baumgartner.impl.view.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.baumgartner.base.util.JSFUtil;
import com.baumgartner.impl.model.Usuario;
import com.baumgartner.impl.model.dao.UsuarioDAOImpl;

@ManagedBean
@SessionScoped
public class TableBean {

	private List<Usuario> usuarios;
	private Usuario usuarioSelecionado;

	@PostConstruct
	public void carregaDados() {
		usuarios = new UsuarioDAOImpl().getAll(Usuario.class);
	}

	public void excluir() {
		if (usuarioSelecionado == null) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO,
					"Selecione novamente um usuário.", null);
		} else {
			String loginUsuario = usuarioSelecionado.getLogin();
			try {
				new UsuarioDAOImpl().remove(usuarioSelecionado);
				usuarioSelecionado = null;
				JSFUtil.addMessage(FacesMessage.SEVERITY_INFO, "Usuário "
						+ loginUsuario + " excluido com sucesso.", null);
				carregaDados();
			} catch (Exception e) {
				JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR,
						"Falha ao excluir usuário " + loginUsuario
								+ ". Contate o administrador.", null);
			}
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}

}