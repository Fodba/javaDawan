package fr.dawan.projweb.entites;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="t_salaries")
public class Salarie implements Serializable {

	@EmbeddedId
	private SalarieId id;
	
	private String nom;

	public SalarieId getId() {
		return id;
	}

	public void setId(SalarieId id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
