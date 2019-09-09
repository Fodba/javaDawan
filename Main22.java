package fr.dawan.formationJava;

public class Main {

	public static void main(String[] args) {
		
		// Utilisation du constructeur par défaut
		Voiture voitureDeJessy = new Voiture();
		
		System.out.println(voitureDeJessy.couleur);
		System.out.println(voitureDeJessy.marque);
		System.out.println(voitureDeJessy.immatriculation);
		
		// Utilisation d'un constructeur surchargé
		Voiture voitureDeCorinne = new Voiture("87-A54-A", "Renault", "Orange");
		
		System.out.println(voitureDeCorinne.couleur);
		System.out.println(voitureDeCorinne.marque);
		System.out.println(voitureDeCorinne.immatriculation);
		
		// On peut soit passé des valeurs en dur directement dans la méthode
		// soit passé des variables avec des valeurs
		String nom = "Titi";
		Utilisateur rachid = new Utilisateur(17, "Rachid", nom, 'M');
		
		// Ici nombreUtilisateur = 1
		System.out.println("Nombre utilisateurs : " + Utilisateur.nombreUtilisateur);
		
		Utilisateur vincent = new Utilisateur(18, "Vincent", "tutu", 'M');
		
		// Ici nombreUtilisateur = 2
		System.out.println("Nombre utilisateurs : " + Utilisateur.nombreUtilisateur);
		
		//Appel de méthode de classe
		Utilisateur.afficherNombreUtilisateur();
		
		// Appel de méthode d'instance
		vincent.afficherNombreUtilisateurNonStatic();
		
	
	}

}
