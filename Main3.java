package fr.dawan.rappelCours;

public class Main {

	public static void main(String[] args) {

		Rappel2 rappel; // rappel vaut null

		// Pour instancier un objet, utiliser le mot clé new + appel d'un constructeur
		// Appel par défaut, tous les attributs sont initialisé par défaut
		// NomClasse nomObjet = new Constructeur();
		Rappel2 rappel2 = new Rappel2();
		System.out.println(rappel2.identifiant);
		System.out.println(rappel2.nom);

		// Appel d'un constructeur qui intialise certain des attributs, les autres sont
		// initialisés par défaut
		Rappel2 rappel3 = new Rappel2(12, "Jean");
		System.out.println(rappel3.identifiant);
		System.out.println(rappel3.nom);

		// Les tableaux
		// Objet qui va contenir un ensemble de valeurs du meme type ordonnées
		// L'index/indice d'un tableau commence toujours par 0
		// La taille d'un tableau est statique

		
		// Tableau à 1 dimension
		// Soit on fixe directement la taille comme suit :
		int[] tab = new int[250];

		// Standard pour initialisé un tableau
		for (int i = 0; i < tab.length; i++) {
			tab[i] = 100;
		}

		// -1 parce que la case d'indice 250 n'existe pas
		for (int i = 0; i <= tab.length - 1; i++) {
			tab[i] = 100;
		}
		
		//Afficher toutes les valeurs du tableau
		for(int var : tab) {
			//System.out.println(var);
		}

		tab[0] = 10;

		// Soit on initialisate la taille est fixé au nombre de valeur qu'on lui envoie
		int[] tableauEntier = { 25, 10, 2, 3, 14, -5, 16, 72, 48, 19 };
		int tableauEntier2[] = { 25, 10, 2, 3, 14, -5, 16, 72, 48, 19 };

		//System.out.println(tableauEntier[2]);
		
		// Tableau à 2 dimensions
		int[][] tab2D = { //c0,c1,c2
							{1, 2, 3}, // ligne 0
							{4, 5, 6}, // ligne 1
							{7, 8, 9}  // ligne 2
										};
		
		// pour accéder à la valeur d'une case :  tab[ligne-1][colonne-1]
		System.out.println(tab2D[2][1]);
		
		
		// QUand on manipule un tableau, il faut faire très attention quand on accède aux case
		// Si on accède à une case qui n'existe pas le programme crash

	}

}
