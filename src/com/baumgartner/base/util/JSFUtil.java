package com.baumgartner.base.util;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class JSFUtil {

	public static void redireciona(String url) {
		ExternalContext ec = FacesContext.getCurrentInstance()
				.getExternalContext();
		try {
			ec.redirect(ec.getRequestContextPath() + url);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public static HttpServletRequest getHttpServletRequest(){
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getRequest();
	}
	
	/*public static HttpServletRequest getHttpSession(boolean criar){
		return (HttpServletRequest) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(criar);
	}*/
	
	/**
	 * Adiciona uma mensagem ao contexto da tela.<br/>
	 * Exemplo de uso:<br/>
	 * JSFUtil.addMessage(FacesMessage.SEVERITY_WARN, "A mensagem", "Detalhe da mensagem");
	 * 
	 * @author Cesar Pereira Viana
	 * 12/11/13 
	 * 
	 * */
	public static void addMessage(FacesMessage.Severity severity, String msg, String detail){
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(severity, msg, detail));
	}
}
