package fr.dawan.formationJava;

public class ExerciceTableau {

	public static void main(String[] args) {
		// Déclaration et initialisation d'un tableau d'entier de 10 cases
		int[] tableauEntier = {-5, 10, 25, -99, 47, 22, 100, -63, 12, 0};
		
		findMin(tableauEntier);
		findMax(tableauEntier);
	}
	
	static void findMin(int[] tab) {
		
		int min = tab[0];
		
		for(int value : tab) {
			if(min > value) {
				min = value;
			}
		}
		
		System.out.println("Valeur Minimale : " + min);
	}
	
	static void findMax(int[] tab) {
		int max = tab[0];
		
		for(int value : tab) {
			if(max < value) {
				max = value;
			}
		}
		
		System.out.println("Valeur Maximale : " + max);
	}

}
