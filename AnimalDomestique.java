package fr.dawan.heritage;

public abstract class AnimalDomestique {

	private int nombrePattes;
	private String nom;
	
	public AnimalDomestique() {

	}
	
	public AnimalDomestique(int nombrePattes, String nom) {
		this.nombrePattes = nombrePattes;
		this.nom = nom;
	}


	public void communiquer() {
		System.out.println("Je communique");
	}

	public int getNombrePattes() {
		return nombrePattes;
	}

	public void setNombrePattes(int nombrePattes) {
		this.nombrePattes = nombrePattes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
