package fr.dawan.projectJavaOne;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args )
	{
		System.out.println( "Hello World!" );

		// Déclaration de ma variable
		int nombre1; 

		// Initialisation de ma variable
		nombre1 = 0;

		// Déclaration et initialisation d'une variable
		long nombre2 = 123L;

		// Affichage des valeurs dans la console
		System.out.println(nombre1);
		System.out.println(nombre2);

		System.out.println(multiplication(2,3));
		MaClasse monObjet = new MaClasse();

		System.out.println("------------------------------------------------------------");
		System.out.println(plusPetit(25, 19));
		System.out.println(plusQue2(5, 4,1, 15));
		System.out.println("------------------------------------------------------------");
		boucleWhile();
		System.out.println("------------------------------------------------------------");
		
		int[] tableauEntier =  new int [15];

		tableauEntier[0] = 25;
		tableauEntier[1] = 4;
		tableauEntier[2] = 137;
		tableauEntier[3] = 785;

		System.out.println(tableauEntier[0]);
		System.out.println(tableauEntier[1]);
		System.out.println(tableauEntier[2]);
		System.out.println(tableauEntier[3]);
		System.out.println(tableauEntier[4]);
		// On essaye d'accéder à un indice inexistant
		//System.out.println(tableauEntier[14]);
		
		System.out.println(tableauEntier.length);

		System.out.println("------------------------------------------------------------");
		for (int i = 0; i < tableauEntier.length; i++) {
			System.out.println(tableauEntier[i]);
		}

		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------------------------------------------");
		for (int caseDeMonTableau : tableauEntier) {
			System.out.println(caseDeMonTableau);
		}
		

		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------------------------------------------");
		
		int [] exoTableau = new int[10];
        exoTableau[0] = 10;
        exoTableau[1] = 234;
        exoTableau[2] = 14;
        exoTableau[3] = 17;
        exoTableau[4] = 1;
        exoTableau[5] = 20;
        exoTableau[6] = 35;
        exoTableau[7] = -47;
        exoTableau[8] = 58;
        exoTableau[9] = 79;

		System.out.println();
		System.out.println("------------------------------------------------------------");
		System.out.println("------------------------------------------------------------");
		afficherTableau(exoTableau);
		System.out.println("------------------------------------------------------------");
        System.out.println("minimum: "+minTableau(exoTableau));
		System.out.println("------------------------------------------------------------");
        System.out.println("maximum: "+maxTableau(exoTableau));
		System.out.println("------------------------------------------------------------");
        System.out.println("moyenne: "+moyenneTableau(exoTableau));
        trierTableau(exoTableau);
		
		
		
		
		
		
	}
	
	public static void afficherTableau(int[] tableau) {
		System.out.println("TABLEAU");
		for (int i = 0; i < tableau.length; i++) {
			System.out.println(tableau[i]);
		}
	}

	public static double multiplication(double num1, double num2) {
		return num1 * num2;
	}

	public static double plusPetit(double num1, double num2) {
		return (num1<num2) ? num1 : num2; 
	}

	public static double plusQue2(double num1, double num2, double num3, double num4) {
		return plusPetit(plusPetit(num1, num2),plusPetit(num3, num4)); 
	}

	static void boucleWhile() {
		int i = 0;

		while(i<10) {
			System.out.println(i);
			i++;
		}
		System.out.println("Boucle terminée");
	}
	
	public static int minTableau(int[] tableau) {
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < tableau.length; i++) {
			if(min > tableau[i]) {
				min = tableau[i];
				System.out.println(min);
			}
		}
		
		return min;
	}
	
	public static int maxTableau(int[] tableau) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < tableau.length; i++) {
			if(max < tableau[i]) {
				max = tableau[i];
			}
		}
		
		return max;
	}
	
	public static double moyenneTableau(int[] tableau) {
		int result = 0;
		for (int i = 0; i < tableau.length; i++) {
			result += tableau[i];
		}
		result /= tableau.length;
		
		return result;
	}
	
	public static int[] trierTableau(int[]  p_tableau) {
		int[] tableau = p_tableau;
		
		int temp = 0;
		for (int i = 0; i < tableau.length; i++) {
			for (int j = 0; j < tableau.length; j++) {
				if(tableau[j]>tableau[i]) {
					temp = tableau[j];
					tableau[j] = tableau[i];
					tableau[i] = temp;
				}
			}
		}
		
		afficherTableau(tableau);
		
		return tableau;
	}

}

