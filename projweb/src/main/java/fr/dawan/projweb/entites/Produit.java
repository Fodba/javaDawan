package fr.dawan.projweb.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_produits")
public class Produit implements Serializable {
	// enumération
	public enum EtatProduit {
		TB, B, M
	}

	// propriétés _____________________
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(precision = 2)
	private float prix;

	@Temporal(TemporalType.DATE) // dates
	private Date dateAchat;

	@Enumerated(EnumType.STRING) // enumeration
	private EtatProduit etat;

	@Version // gestion de la concurrence
	private int version;

	@Transient // ignorer le mapping en BDD
	private String champNonMappe;

	@ElementCollection(targetClass = String.class)
	// @CollectionTable pour spécifier le nom
	// de la table t_produits_observations
	private List<String> observations;

	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	private List<Caracteristique> caracteristiques;

	@ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable pour personnaliser
	// la table de jointure
	private List<Fournisseur> fournisseurs;

	// ________________________________
	public long getId() {
		return id;
	}

	public List<Fournisseur> getFournisseurs() {
		return fournisseurs;
	}

	public void setFournisseurs(List<Fournisseur> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	public String getChampNonMappe() {
		return champNonMappe;
	}

	public void setChampNonMappe(String champNonMappe) {
		this.champNonMappe = champNonMappe;
	}

	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Produit() {
		super();
	}

	public Produit(long id, String description, float prix, Date dateAchat, EtatProduit etat, int version) {
		super();
		this.id = id;
		this.description = description;
		this.prix = prix;
		this.dateAchat = dateAchat;
		this.etat = etat;
		this.version = version;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public Date getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(Date dateAchat) {
		this.dateAchat = dateAchat;
	}

	public EtatProduit getEtat() {
		return etat;
	}

	public void setEtat(EtatProduit etat) {
		this.etat = etat;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<String> getObservations() {
		return observations;
	}

	public void setObservations(List<String> observations) {
		this.observations = observations;
	}

}
