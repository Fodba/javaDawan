package fr.dawan.heritage;

// Dans Java on ne peut hériter que d'une seule classe
// Héritage en cascade c'est possible
public class Chat extends AnimalDomestique {

	private String couleurPelage;
	private String race;
	private final int CONSTANTE = 2;
	
	public Chat() {
		
	}
	
	public Chat(String couleurPelage, String race, int nombrePattes , String nom) {
		// super fait référence à la classe mère
		// ici super() représente l'appel au constructeur de la classe mère
		super(nombrePattes, nom);
		this.couleurPelage = couleurPelage;
		this.race = race;
	}
	


	public String getCouleurPelage() {
		return couleurPelage;
	}

	public void setCouleurPelage(String couleurPelage) {
		this.couleurPelage = couleurPelage;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	@Override
	public void communiquer() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}
