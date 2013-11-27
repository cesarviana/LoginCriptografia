package com.baumgartner.impl.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "CD_USUARIO_SEQ", initialValue = 5, allocationSize = 1, sequenceName = "usuario_cd_usuario_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CD_USUARIO_SEQ")
	@Column(name = "cd_usuario")
	private Integer cdUsuario;

	@Column(name = "senha")
	private String senha;

	@Column(name = "login")
	private String login;
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	// bi-directional many-to-many association to Nivel
	@ManyToMany
	@JoinTable(name = "usuario_nivel", joinColumns = { @JoinColumn(name = "login", referencedColumnName = "login") }, inverseJoinColumns = { @JoinColumn(name = "nm_nivel", referencedColumnName = "nm_nivel") })
	private List<Nivel> nivels;

	public Integer getCdUsuario() {
		return this.cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Nivel> getNivels() {
		if (this.nivels == null){
			this.nivels = new ArrayList<Nivel>();
		}
		return this.nivels;
	}

	public void setNivels(List<Nivel> nivels) {
		this.nivels = nivels;
	}	
}