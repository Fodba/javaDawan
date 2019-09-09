package fr.dawan.spring.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_produits")
public class Product implements Serializable {
	// enumération
	public enum ProductState {
		VG, G, B
	}

	// propriétés _____________________
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(precision = 2)
	private float price;

	@Temporal(TemporalType.DATE) // dates
	private Date purchaseDate;

	@Enumerated(EnumType.STRING) // enumeration
	private ProductState etat;

	@Version // gestion de la concurrence
	private int version;

	// ________________________________
	public long getId() {
		return id;
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
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Product() {
		super();
	}

	public Product(long id, String description, float prix, Date dateAchat, ProductState etat, int version) {
		super();
		this.id = id;
		this.description = description;
		this.price = prix;
		this.purchaseDate = dateAchat;
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
		return price;
	}

	public void setPrix(float prix) {
		this.price = prix;
	}

	public Date getDateAchat() {
		return purchaseDate;
	}

	public void setDateAchat(Date dateAchat) {
		this.purchaseDate = dateAchat;
	}

	public ProductState getEtat() {
		return etat;
	}

	public void setEtat(ProductState etat) {
		this.etat = etat;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String toCsv() {
		return id + ";" + version + ";" + description + ";" + price + ";" + purchaseDate + ";" + etat;
	}

}
