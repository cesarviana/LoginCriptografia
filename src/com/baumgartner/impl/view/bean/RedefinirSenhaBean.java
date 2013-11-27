package com.baumgartner.impl.view.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.commons.mail.EmailException;

import com.baumgartner.base.util.GeradorDeSenha;
import com.baumgartner.base.util.GerenciaEmail;
import com.baumgartner.base.util.Hash;
import com.baumgartner.base.util.JSFUtil;
import com.baumgartner.impl.model.Usuario;
import com.baumgartner.impl.model.dao.UsuarioDAOImpl;

@ManagedBean
@RequestScoped
public class RedefinirSenhaBean {

	private String email;
	private boolean redefinicaoOk = false;

	public boolean isRedefinicaoOk() {
		return redefinicaoOk;
	}

	public void setRedefinicaoOk(boolean redefinicaoOk) {
		this.redefinicaoOk = redefinicaoOk;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void enviarEmail() throws InterruptedException {
		UsuarioDAOImpl dao = new UsuarioDAOImpl();
		if (dao.count(this.email) > 0) {

			try {
				String novaSenha = GeradorDeSenha.geraSenha(); 
				new GerenciaEmail().enviaEmailRedefinicaoDeSenha(email, novaSenha);
				
				Usuario usuario = dao.getUsuario(email);
				usuario.setSenha(Hash.MD5(novaSenha));
				dao.save(usuario);
				
				redefinicaoOk = true;
			} catch (EmailException e) {
				JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro ao enviar o e-mail.", null);
			} catch (Exception e){
				JSFUtil.addMessage(FacesMessage.SEVERITY_ERROR,
						"Ocorreu um erro ao redefinir a senha.", null);
			}

		} else {
			JSFUtil.addMessage(FacesMessage.SEVERITY_WARN,
					"O e-mail não foi encontrado na base de dados.", null);
		}
	}
}
