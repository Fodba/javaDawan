package fr.dawan.formationJava;

public class Utilisateur {

	// Variables d'instance
	int age;
	String prenom;
	String nom;
	char sexe;
	
	// Constructeur par défaut
	Utilisateur() {
		
	}
	
	// Constructeur surchargé
	Utilisateur(int age, String prenom, String nom, char sexe) {
		this.age= age;
		this.nom=nom;
		this.prenom = prenom;
		this.sexe =sexe;
	}
}
