package com.baumgartner.impl.view.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import com.baumgartner.base.util.Hash;
import com.baumgartner.base.util.JSFUtil;
import com.baumgartner.impl.model.Nivel;
import com.baumgartner.impl.model.Usuario;
import com.baumgartner.impl.model.dao.NivelDAOImpl;
import com.baumgartner.impl.model.dao.UsuarioDAOImpl;

@ManagedBean
@SessionScoped
public class CadastroUsuarioBean {

	private String login;
	private String senha;
	private List<String> niveis;
	private List<Usuario> usuarios;
	private List<Usuario> usuariosSelecionado;
	
	public List<Usuario> getUsuariosSelecionado() {
		return usuariosSelecionado;
	}

	public void setUsuariosSelecionado(List<Usuario> usuariosSelecionado) {
		this.usuariosSelecionado = usuariosSelecionado;
	}

	private SelectItem[] itens;

	@PostConstruct
	private void carregaDados() {
		itens = new SelectItem[3];
		itens[0] = new SelectItem("");
		itens[1] = new SelectItem("25f9e794323b453885f5181f1b624d0b");
		itens[2] = new SelectItem("0a1c6944cb66d02ccefac35620ce2e51");
		
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		this.usuarios = dao.getAll(Usuario.class);
	}

	public SelectItem[] getItens() {
		return itens;
	}

	private void limpaCampos() {
		login = "";
		senha = "";
		niveis = null;
	}

	public void salvar(ActionEvent e) {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();

		if (dao.count(login) > 0) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN,
					"Este login já está cadastrado", null);
		} else {
			Usuario usuario = new Usuario();
			usuario.setLogin(login);
			usuario.setSenha(Hash.MD5(senha));
			NivelDAOImpl nivelDao = new NivelDAOImpl();
			for (String cdNivel : niveis) {
				Nivel nivel = nivelDao.getById(Nivel.class,
						Integer.parseInt(cdNivel));
				usuario.getNivels().add(nivel);
			}
			dao.save(usuario);
			JSFUtil.addMessage(FacesMessage.SEVERITY_INFO,
					"Usuário cadastrado com sucesso.", null);
			carregaDados();
			limpaCampos();
		}
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<String> getNiveis() {
		return niveis;
	}

	public void setNiveis(List<String> niveis) {
		this.niveis = niveis;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
