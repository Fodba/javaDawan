package fr.dawan.exerciceHeritage;

public class Voiture extends Vehicule {

	private int nombreRoues;
	private String immatriculation;
	private String marque;
	
	public Voiture() {
		super();
	}

	// Constructeur surchargé
	public Voiture(int nombreRoues, String immatriculation, String marque) {
		super();
		this.nombreRoues = nombreRoues;
		this.immatriculation = immatriculation;
		this.marque = marque;
	}

	@Override
	public boolean isRoule() {
		return true;
	}

}
