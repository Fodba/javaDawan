package fr.dawan.projectJavaOne;

public class Voiture {
	String marque;
	String immatriculation;
	String couleur;
	
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public Voiture() {
		super();
	}

	public Voiture(String marque, String immatriculation) {
		super();
		this.marque = marque;
		this.immatriculation = immatriculation;
	}

	public Voiture(String marque, String immatriculation, String couleur) {
		super();
		this.marque = marque;
		this.immatriculation = immatriculation;
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + marque + ", immatriculation=" + immatriculation + ", couleur=" + couleur + "]\n";
	}
	
	
	
}
