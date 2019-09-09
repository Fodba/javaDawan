package fr.dawan.exerciceHeritage;

public abstract class Vehicule {
	private Boolean isEnEtatDeMarche;

	public Boolean getIsEnEtatDeMarche() {
		return isEnEtatDeMarche;
	}

	public void setIsEnEtatDeMarche(Boolean isEnEtatDeMarche) {
		this.isEnEtatDeMarche = isEnEtatDeMarche;
	}

	public Vehicule() {
	}

	public Vehicule(Boolean isEnEtatDeMarche) {
		super();
		this.isEnEtatDeMarche = isEnEtatDeMarche;
	}
	
	
	
	
	
	
	
}
