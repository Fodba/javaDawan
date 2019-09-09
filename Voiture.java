package fr.dawan.formationJava;

public class Voiture {
	
	// Variables d'instances
	String immatriculation;
	String couleur;
	String marque;
	
	// Variables de classe
	static int nombreVoiture;
	
	// Constructeur par défaut
	// Par défaut les variables d'instance sont mis à null pour les String
	Voiture() {
		
	}
	
	// Constructeur surchargé
	Voiture(String immatriculation, String marque, String couleur) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.couleur = couleur;
	}
	
	// Autre constructeur surchargé possible, ici la couleur sera toujours fixé à "Blanche"
	Voiture(String immatriculation, String marque) {
		this.immatriculation = immatriculation;
		this.marque = marque;
		this.couleur = "Blanche";
	}
	
	static void afficherNombreVoiture() {
		System.out.println(Voiture.nombreVoiture);
	}

}
