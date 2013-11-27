package com.baumgartner.impl.view.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.primefaces.context.RequestContext;

import com.baumgartner.base.util.Hash;
import com.baumgartner.base.util.JSFUtil;
import com.baumgartner.impl.model.Usuario;
import com.baumgartner.impl.model.dao.UsuarioDAOImpl;

@ManagedBean
@ViewScoped
public class ConfiguracoesUsuarioBean {

	private String senha, novaSenha, confSenha;

	public void redefinirSenha() {
		
		String login = JSFUtil.getHttpServletRequest().getRemoteUser();

		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		if (dao.count(login, Hash.MD5(senha)) == 0) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN,
					"Senha atual incorreta", null);
		} else if (!novaSenha.equals(confSenha)) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN,
					"As senhas não conferem", null);
		} else if (senha.equals(novaSenha)) {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN,
					"Você digitou a mesma senha", null);
		} else {
			try {
				Usuario usuario = dao.getUsuario(login, Hash.MD5(senha));
				usuario.setSenha(Hash.MD5(novaSenha));
				dao.save(usuario);
				JSFUtil.addMessage(FacesMessage.SEVERITY_INFO,
						"Senha redefinida com sucesso", null);
				this.senha = "";
				this.novaSenha = "";
				this.confSenha = "";
				RequestContext.getCurrentInstance().execute("dialog.hide()");
			} catch (Exception ex) {
				JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR,
						"Houve um erro ao redefir a senha", null);
			}
		}
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}

	public String getConfSenha() {
		return confSenha;
	}

	public void setConfSenha(String confSenha) {
		this.confSenha = confSenha;
	}

}
