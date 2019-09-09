package fr.dawan.heritage;

public class MainHeritage {
	

	public static void main(String[] args) {
		// On ne peut plus creer un AnimalDomestique car la classe est maintenant abstract
//		AnimalDomestique animal = new AnimalDomestique();
//		animal.communiquer();
		
		Chat chat = new Chat();
		chat.communiquer();
		
		Chien chien = new Chien();
		chien.communiquer();
		
		// Polymorphisme avec l'héritage
		// Capacité à mélanger dans une collection de type d'une classe mère, 
		// la classe mère et ses classes filles
		AnimalDomestique[] tabAnimalDomestique = new AnimalDomestique[3];
		// On ne peut plus mettre dans le tableau des objets de type AnimalDomestique 
		// car la classe est maintenant abstract
		// tabAnimalDomestique[0] = new AnimalDomestique();
		tabAnimalDomestique[0] = new Chien();
		tabAnimalDomestique[1] = new Chien();
		tabAnimalDomestique[2] = new Chat();
		
		// instanceof
		
		for(AnimalDomestique value : tabAnimalDomestique) {
			// objet appartient à la classe Chien
			if(value instanceof Chien ) {
				System.out.println("Ma classe est Chien");
			}
			else if(value instanceof Chat ) {
				System.out.println("Ma classe est Chat");
			}
			else {
				System.out.println("Ma classe est AnimalDomestique");
			}
		}
		
		
		// Polymorphisme avec interface
	}

}
