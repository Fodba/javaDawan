package fr.dawan.exercices;

public class Promotion {
	Etudiant[] tableauEtudiant;
	String niveauEtude;


	public Promotion() {
		this.tableauEtudiant = new Etudiant[250];
	}
	

	
	public Promotion(String niveauEtude) {
		this.tableauEtudiant = new Etudiant[250];
		this.niveauEtude = niveauEtude;
	}
	
	public void initPromo() {
		for (int i = 0; i < tableauEtudiant.length; i++) {
			Etudiant etudiant = new Etudiant();
			this.tableauEtudiant[i] = etudiant;
		}
	}

	public String ajouterEtudiant(String niveauEtude) {
		boolean complet = true;
		this.niveauEtude = niveauEtude;
		for (int i = 0; i < this.tableauEtudiant.length; i++) {
			if (this.tableauEtudiant[i] == null) {
				Etudiant etudiant = new Etudiant();
				this.tableauEtudiant[i] = etudiant;
				complet = false;
			}
		}
		if(complet) {
			return "Echec de l'insertion !";
		}
		else {
			return "Insertion réussie !";
		}
	}


	public void afficherEtudiants() {
		for (int i = 0; i < tableauEtudiant.length; i++) {
			if(this.tableauEtudiant[i] != null && this.tableauEtudiant[i].getNiveauEtude() == this.niveauEtude) {
				this.tableauEtudiant[i].afficherInformationEtudiant();
			}
		}
	}

}
