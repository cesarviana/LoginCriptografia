package com.baumgartner.base.view.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.baumgartner.base.util.JSFUtil;

@ManagedBean
@RequestScoped
public class LoginBean {

	private String login;
	
	public LoginBean() {
		login = JSFUtil.getHttpServletRequest().getRemoteUser();
	}

	public boolean isAdmin(){
		return JSFUtil.getHttpServletRequest().isUserInRole("admin");
	}
	
	public void sair() {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		ec.invalidateSession();
		JSFUtil.redireciona("/default/index.xhtml");
	}
	
	// getters and setters
	public String getLogin() {
		return login;
	}
}
