package fr.dawan.exercices;


// Convention JavaBean
// Au moins un constructeur vide
// Des getters et des setters pour tous les attributs private
public class Etudiant {
	private String nom, prenom, sexe, niveauEtude;
	private int age;
	static int nombreEtudiant;


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

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		if(sexe == "homme" || sexe == "femme")
			this.sexe = sexe;
	}

	public String getNiveauEtude() {
		return niveauEtude;
	}

	public void setNiveauEtude(String niveauEtude) {
		this.niveauEtude = niveauEtude;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age > 0) {
			this.age = age;
		}
		else {
			System.out.println("Cette valeur ne peut être négative.");
		}
	}


	public Etudiant() {
		this.nom = "Vincent";
		this.prenom = "Jan Michael";
		this.sexe = "homme";
		this.niveauEtude = "6e";
		this.age = 18;
		nombreEtudiant++;
	}

	public Etudiant(String nom, String prénom, String sexe, String niveauEtude, int age) {
		super();
		this.nom = nom;
		this.prenom = prénom;
		this.sexe = sexe;
		this.niveauEtude = niveauEtude;
		this.age = age;
		nombreEtudiant++;

	}

	public void afficherInformationEtudiant() {
		System.out.println("Je m'appelle " + this.prenom + " " + this.nom +	".\nJe suis un(e) " + this.sexe + ". J'ai " + this.age + " ans et je suis en " + this.niveauEtude + ".\n-------------------------");
	}

	public static void afficherNombreEtudiant() {
		System.out.println("Il y a " + nombreEtudiant + " etudiants");
	}




}
