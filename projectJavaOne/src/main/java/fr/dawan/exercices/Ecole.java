package fr.dawan.exercices;

public class Ecole {
	String nom, adresse;
	Promotion[] tableauPromotion;
	
	public Ecole() {
		super();
		this.tableauPromotion = new Promotion[250];
	}

	public Ecole(String nom, String adresse) {
		super();
		this.nom = nom;
		this.adresse = adresse;
		this.tableauPromotion = new Promotion[250];
	}
	
	public String ajouterPromotion(String promotion) {
		boolean complet = true;
		for (int i = 0; i < this.tableauPromotion.length; i++) {
			if (this.tableauPromotion[i] == null) {
				Promotion promo = new Promotion(promotion);
				this.tableauPromotion[i] = promo;
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
	
	public String ajouterPromotion(Promotion promotion) {
		boolean complet = true;
		for (int i = 0; i < this.tableauPromotion.length; i++) {
			if (this.tableauPromotion[i] == null) {
				this.tableauPromotion[i] = promotion;
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
	
	public void afficherPromotions() {
		for (int i = 0; i < tableauPromotion.length; i++) {
			if(this.tableauPromotion[i] != null) {
				this.tableauPromotion[i].afficherEtudiants();
			}
		}
	}
	
	
	
	
}
