package fr.dawan.clientWs.forms;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;

import org.springframework.stereotype.Component;

@Component
public class ContactForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	private String id;

	@XmlAttribute
	private String version;

	@NotNull(message = "{prenom.not.empty}")
	private String prenom;

	@NotNull(message = "{nom.not.empty}")
	private String nom;

	@NotNull(message = "{telephone.not.empty}")
	private String telephone;

	@NotNull(message = "{adresse.not.empty}")
	private String adresse;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
