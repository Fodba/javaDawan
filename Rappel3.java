package fr.dawan.rappelCours;

public class Rappel {

	public static void main(String[] args) {
		// Les Variables

		// Les types primitifs : 
		// Entier : byte, short, int, long
		
		int a = 2;
		short c = 20; 
		long l = 25L;
		// Décimaux : double, float
		float b = 2.5f;
		// character : char
		char o = 's';
		// boolean 
		boolean bool = true;
		
		// Les types références
		
		String maString = new String("coucou");
		String bb = "je suis une chaine de caractères";
		

		// Les Wrappers
		
		Integer monInt = new Integer(2);
		Double monDouble = new Double(2.5);
		Float monFLoat = new Float(2.5f);
		Short monShort = new Short((short)2);
		Long monLong = new Long((long) 2.5);
		Boolean monBool = new Boolean(true);
		Character monChar = new Character('a');
		Byte monByte = new Byte((byte) 5);
		
		// Les Conditions
		boolean maCondition = true;
		
		if(maCondition == true) {
			a = 1;
		}
		else {
			a = 0;
		}
		
		// Opérateur ternaire => équivalent au if else dessus
		a = (maCondition == true) ? 1 : 0;
		
		// switch
		
		switch(a) {
		case 0 :
			// Instructions
			break;
		case 1 : 
			// Instructions
			break;
		default :
			// Instructions
		}
		
		// Les Boucles
		// Tant que je fais ...
		while(maCondition) {
			// Instructions
		}
		
		// Fait .... Tant que
		do {
			// Instructions
		} while(maCondition);
		
		
	}

}
