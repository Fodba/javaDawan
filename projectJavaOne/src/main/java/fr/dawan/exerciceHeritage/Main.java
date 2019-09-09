package fr.dawan.exerciceHeritage;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		
		Vehicule[] tabVehicule = new Vehicule[50];
		int nombre = 0;
		for (int i = 0; i < tabVehicule.length; i++) {
			nombre = r.nextInt(2);
			switch(nombre) {
				case 0:
					tabVehicule[i] = new Voiture();
					break;
				case 1:
					tabVehicule[i] = new Avion();
					break;
				default:
					tabVehicule[i] = new Voiture();
			}
			
		}
		
		for (int i = 0; i < tabVehicule.length; i++) {
			System.out.println(i+1);
			//tabVehicule[i].isRoule();
		}
		/*for(Vehicule vehicule : tabVehicule) {
			vehicule.isRoule();
		}*/
		
		List<Voiture> listVoiture = new ArrayList<Voiture>();

		listVoiture.add(new Voiture());
		listVoiture.add(new Voiture());
		listVoiture.add(new Voiture());
		listVoiture.add(new Voiture());

		listVoiture.size();
		System.out.println(listVoiture.size());

		System.out.println();

		String s = "String de test";
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
		s += " ";
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
		System.out.println();
		
		int[] tab = new int[10];
		System.out.println(Integer.toHexString(System.identityHashCode(tab)));
		tab[0] = 5;
		System.out.println(Integer.toHexString(System.identityHashCode(tab)));
		
		/*String s = "String de test";
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
		s += " rien de plus";
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
		
		System.out.println(Integer.toHexString(System.identityHashCode(s)));
		*/
		
		
		
	}

}
