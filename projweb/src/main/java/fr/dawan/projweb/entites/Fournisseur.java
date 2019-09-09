package fr.dawan.projweb.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name="t_fournisseurs")
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;

	@ManyToMany(mappedBy = "fournisseurs", 
			    cascade = CascadeType.ALL)
	private List<Produit> produits;
	
	@Version
	private int version;

	@OneToOne(optional=false)
    @JoinColumn(name="adr_id", unique=true, nullable=false, updatable=false)
    private Adresse adresse;
	
	
	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
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




	public List<Produit> getProduits() {
		return produits;
	}




	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}




	public int getVersion() {
		return version;
	}




	public void setVersion(int version) {
		this.version = version;
	}




	public Fournisseur(long id, String nom, List<Produit> produits, int version) {
		super();
		this.id = id;
		this.nom = nom;
		this.produits = produits;
		this.version = version;
	}




	public Fournisseur() {
		super();
	}
	
	
	
	
}






