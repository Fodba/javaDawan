package fr.dawan.exerciceHeritage;

// Utilisation du mot clé abstract
public abstract class Vehicule {
	private boolean isEnEtatMarche;

	public Vehicule() {
		
	}
	
	public Vehicule(boolean isEnEtatMarche) {
		this.isEnEtatMarche = isEnEtatMarche;
	}

	public boolean isEnEtatMarche() {
		return isEnEtatMarche;
	}

	public void setEnEtatMarche(boolean isEnEtatMarche) {
		this.isEnEtatMarche = isEnEtatMarche;
	}
	
	// Utilisation du mot clé abstract pour les méthodes abstract
	// Pas de corps (donc pas d'accolade) et elle finissent ;
	// Une signature de méthode
	// Une méthode abstraite devra être implémenté dans les classes filles
	public abstract boolean isRoule();
	
}
