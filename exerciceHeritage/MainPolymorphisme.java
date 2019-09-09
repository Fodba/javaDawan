package fr.dawan.exerciceHeritage;

public class MainPolymorphisme {

	public static void main(String[] args) {
		
		// Déclaration d'un tableau
		Vehicule[] tabVehicule = new Vehicule[10];

		// Initialiser les cases du tableau
		
		// On commence à la case 0 puis on incrémente l'index i de 2
		// à chauqe tour de boucle => Pour remplir qu'une case sur 2 avec des avions
		for(int i = 0 ; i < tabVehicule.length ; i+=2) {
			tabVehicule[i] = new Avion();
		}
		
		// On commence à la case 1 puis on incrémente l'index i de 2
		// à chauqe tour de boucle => Pour remplir qu'une case sur 2 avec des voitures
		// en décalage par rapport à la boucle for précédente
		for(int i = 1 ; i < tabVehicule.length ; i+=2) {
			tabVehicule[i] = new Voiture();
		}
		
		// Appelé la méthode isRoule pour voir que la méthode appelé dépends bien du 
		// type de l'objet dans la case du tableau
		for(Vehicule value : tabVehicule) {
			System.out.println(value.isRoule());
		}
		
	}

}
