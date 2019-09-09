package fr.dawan.projectJavaOne;

public class MaClasse {
	public static void main(String[] args) {
		
		ClassJavaUn monObjet = new ClassJavaUn();
		
		monObjet.marque = "YAMAHA";
		monObjet.nombreRoue = 2;
		
		monObjet.afficherMaClass();
		System.out.println(monObjet.toString());
		

		
		ClassJavaUn monObjet2 = new ClassJavaUn(4,"SUBARU");
		monObjet2.afficherMaClass();
		System.out.println(monObjet2.toString());
		

		Voiture voiture1 = new Voiture("Clio", "ACB45JF");
		Voiture voiture2 = new Voiture("Peugeot", "IGV10BR","Rouge");

		System.out.println();
		System.out.println();
		System.out.println(voiture1.toString());
		System.out.println(voiture2.toString());
		
		
		Utilisateur theo = new Utilisateur("Guerinot","Théodore","Non binaire",-20);
		System.out.println(theo.toString());
		
		
		
	}
}
