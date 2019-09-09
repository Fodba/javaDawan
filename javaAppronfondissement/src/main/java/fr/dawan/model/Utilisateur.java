package fr.dawan.model;

import java.io.Serializable;

import javax.swing.JFrame;

// Les classes du model doivent absolument respecter la convention
// JavaBean (attributs private avec getters + setters, implements
// Serializable + constructeur vide sans paramètre)
public class Utilisateur implements Serializable {
	
	// clé primaire : pour retrouver mon objet dans la base
	// Utilisation du mot clé transient sur les attributs qu'on
	// ne veut pas enregistrer en BDD
	private long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String telephone;
	private String login;
	private String password;
	
	// Constructeur vide sans paramètre 
	// utilisé pour créer les objets qu'on récupère depuis la BDD (base de données)
	public Utilisateur() {

	}

	public long getIdentifiant() {
		return id;
	}

	public void setIdentifiant(long identifiant) {
		this.id = identifiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", telephone="
				+ telephone + ", login=" + login + ", password=" + password + "]";
	}
	
	
	
	
	
	
	
}
