package com.baumgartner.base.util;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class GerenciaEmail {

	private final String 
			HOST_NAME = "smtp.gmail.com",
			FROM = "cesar.pviana@gmail.com",
			LOGIN = "cesar.pviana@gmail.com",
			SENHA = "Cpv29/12-1994";
			
	public void enviaEmailRedefinicaoDeSenha(String to, String novaSenha) throws EmailException {
		
		String msg = "Esta � a sua nova senha de acesso: " + novaSenha;
		
		Email email = new SimpleEmail();
		email.setHostName(HOST_NAME);
		email.addTo(to);
		email.setFrom(FROM, "Administrador");
		email.setSubject("Redefini��o de senha");
		email.setMsg(msg);
		email.setAuthentication(LOGIN, SENHA);
		email.setSmtpPort(465);
		email.setSSLOnConnect(true);
		email.send();
	}
}
