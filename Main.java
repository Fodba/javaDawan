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
		
		System.out.println(rachid.age);
		System.out.println(rachid.nom);
		System.out.println(rachid.prenom);
		System.out.println(rachid.sexe);
	}

}
