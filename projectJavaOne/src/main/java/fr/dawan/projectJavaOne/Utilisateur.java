package fr.dawan.projectJavaOne;

public class Utilisateur {
	String nom, prenom, sexe;
	Integer age;

	
	
	
	public Utilisateur() {
		super();
		this.nom = "Jean";
		this.prenom = "Delaporte";
		this.sexe = "feminin";
		this.age = 18;
	}


	public Utilisateur(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = "feminin";
		this.age = 18;
	}
	
	
	public Utilisateur(String nom, String prenom, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = "feminin";
		this.age = age;
	}


	public Utilisateur(String nom, String prenom, String sexe, Integer age) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.age = age;
	}


	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
}
