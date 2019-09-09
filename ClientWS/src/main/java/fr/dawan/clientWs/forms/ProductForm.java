package fr.dawan.clientWs.forms;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

import org.springframework.stereotype.Component;

@Component
public class ProductForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String version;

	@NotNull(message = "{price.not.empty}")
	private String price;

	@NotNull(message = "{description.not.empty}")
	private String description;

	@NotNull(message = "{purchaseDate.not.empty}")
	private String purchaseDate;

	@NotNull(message = "{state.not.empty}")
	private String state;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}
