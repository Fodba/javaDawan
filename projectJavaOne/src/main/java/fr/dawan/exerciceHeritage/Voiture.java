package fr.dawan.exerciceHeritage;

public class Voiture extends Vehicule {
	private int nombreRoues, immatriculation, marque;

	public int getNombreRoues() {
		return nombreRoues;
	}

	public void setNombreRoues(int nombreRoues) {
		this.nombreRoues = nombreRoues;
	}

	public int getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getMarque() {
		return marque;
	}

	public void setMarque(int marque) {
		this.marque = marque;
	}

	public Voiture() {
		super();
	}

	public Voiture(int nombreRoues, int immatriculation, int marque) {
		super();
		this.nombreRoues = nombreRoues;
		this.immatriculation = immatriculation;
		this.marque = marque;
	}
	
	public boolean isRoule() {
		boolean roule = true;
		System.out.println("Ce vehicule roule-t-il? : " + roule);
		return roule;
	}
	
}
