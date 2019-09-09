package fr.dawan.projetjaxrs.ws.entites;

import java.io.Serializable;
import java.util.Date;

import javax.ws.rs.Path;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Product implements Serializable {

	// enumération
	public enum ProductState {
		VG, G, B
	}

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private long id;

	@XmlAttribute
	private int version;

	@XmlElement
	private float price;

	@XmlElement
	private String description;

	@XmlElement
	private Date purchaseDate;

	@XmlElement
	private ProductState state;

	public Product() {

	}

	public Product(int version, float price, String description, Date purchaseDate, ProductState state) {
		this.version = version;
		this.price = price;
		this.description = description;
		this.purchaseDate = purchaseDate;
		this.state = state;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public ProductState getState() {
		return state;
	}

	public void setState(ProductState state) {
		this.state = state;
	}

}
