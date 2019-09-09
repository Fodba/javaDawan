package fr.dawan.formationJava;

public class Utilisateur {

	// Variables d'instance
	int age;
	String prenom;
	String nom;
	char sexe;
	
	// Variables de classe;
	static int nombreUtilisateur = 0;
	
	// Constructeur par défaut
	Utilisateur() {
		
	}
	
	// Constructeur surchargé
	Utilisateur(int age, String prenom, String nom, char sexe) {
		this.age= age;
		this.nom=nom;
		this.prenom = prenom;
		this.sexe =sexe;
		Utilisateur.nombreUtilisateur++;
	}
	
	// Méthode de classe (On ne peut manipuler que des variables static ou des méthodes static
	// Ne peut être appelé que à partir de la classe : Utilisateur.afficherNombreUtilisateur()
	static void afficherNombreUtilisateur() {
		System.out.println(Utilisateur.nombreUtilisateur);
		//Appel à des méthode non static impossible
		//afficherNombreUtilisateurNonStatic();
	}
	
	// Méthode d'instances (On peut tout manipuler)
	// Ne peut être appelé que à partir d'un objet Utilisateur : pierre.afficherNombreUtilisateurNonStatic
	void afficherNombreUtilisateurNonStatic() {
		System.out.println(Utilisateur.nombreUtilisateur);
	}
}
