package fr.dawan.exercices;

public class Main {

	public static void main(String[] args) {
		Ecole ecole = new Ecole();
		for (int i = 0; i < ecole.tableauPromotion.length; i++) {
			Promotion promo = new Promotion("6e");
			promo.initPromo();
			ecole.ajouterPromotion(promo);
		}/*
		for (int i = 0; i < ecole.tableauPromotion.length; i++) {
			ecole.tableauPromotion[i].afficherEtudiants();
		}*/
		ecole.afficherPromotions();
		//System.out.println(Etudiant.nombreEtudiant);
		Etudiant.afficherNombreEtudiant();
	}
}
