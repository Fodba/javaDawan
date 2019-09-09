package fr.dawan.exerciceHeritage;

// Classe fille, qui hérite de Vehicule avec le mot clé extends
public class Avion extends Vehicule {

	public Avion() {
		
	}
	
	// Redéfinition de la méthode abstraite
	// Est-ce que mon avion roule ?
	// Convention pour méthode qui retourne boolean la nom commence par is
	@Override
	public boolean isRoule() {
		return false;
	}

}
