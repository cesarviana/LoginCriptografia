package com.baumgartner.impl.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="NIVEL_CDNIVEL_GENERATOR", allocationSize = 1, sequenceName="nivel_cd_nivel_seq" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NIVEL_CDNIVEL_GENERATOR")
	@Column(name="cd_nivel")
	private Integer cdNivel;

	@Column(name="nm_nivel")
	private String nmNivel;
	
	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="nivels")
	private List<Usuario> usuarios;

	
	// getters and setters
	public Integer getCdNivel() {
		return this.cdNivel;
	}

	public void setCdNivel(Integer cdNivel) {
		this.cdNivel = cdNivel;
	}

	public String getNmNivel() {
		return nmNivel;
	}

	public void setNmNivel(String nmNivel) {
		this.nmNivel = nmNivel;
	}
	
	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}