package com.baumgartner.listener;

import javax.servlet.annotation.WebListener;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.baumgartner.impl.model.Usuario;

@WebListener
public class SessionListener implements HttpSessionListener {

    public void sessionCreated(HttpSessionEvent event) {
    	event.getSession().setAttribute("usuario", new Usuario());
    }

    public void sessionDestroyed(HttpSessionEvent arg0) {
    	System.out.println("LOG: Finalizou sessão.");
    }
}
