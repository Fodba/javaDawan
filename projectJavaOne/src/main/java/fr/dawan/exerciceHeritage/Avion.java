package fr.dawan.exerciceHeritage;

public class Avion extends Vehicule implements VehiculeAerien {
	private int nombreRoues, immatriculation, marque;

	public int getNombreRoues() {
		return nombreRoues;
	}

	public void setNombreRoues(int nombreRoues) {
		this.nombreRoues = nombreRoues;
	}

	public int getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(int immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getMarque() {
		return marque;
	}

	public void setMarque(int marque) {
		this.marque = marque;
	}

	public Avion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Avion(int nombreRoues, int immatriculation, int marque) {
		super();
		this.nombreRoues = nombreRoues;
		this.immatriculation = immatriculation;
		this.marque = marque;
	}
	

	
	public boolean isRoule() {	
		boolean roule = false;
		System.out.println("Ce vehicule roule-t-il? : " + roule);	
		return roule;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + immatriculation;
		result = prime * result + marque;
		result = prime * result + nombreRoues;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Avion other = (Avion) obj;
		if (immatriculation != other.immatriculation)
			return false;
		if (marque != other.marque)
			return false;
		if (nombreRoues != other.nombreRoues)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
