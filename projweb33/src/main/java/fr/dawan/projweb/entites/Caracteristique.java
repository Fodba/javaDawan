package fr.dawan.projweb.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name="t_caracteristiques")
public class Caracteristique implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nom;
	
	@Column(nullable = false)
	private String valeur;
	
	@Version
	private int version;
	
	@ManyToOne(cascade = CascadeType.ALL)
	//@JoinColumn pour personnaliser la colonne
	//produit_id
	private Produit produit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Caracteristique() {
		super();
	}

	public Caracteristique(long id, String nom, String valeur, int version, Produit produit) {
		super();
		this.id = id;
		this.nom = nom;
		this.valeur = valeur;
		this.version = version;
		this.produit = produit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caracteristique other = (Caracteristique) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
}
