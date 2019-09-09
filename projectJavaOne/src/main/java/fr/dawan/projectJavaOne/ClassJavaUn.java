package fr.dawan.projectJavaOne;

public class ClassJavaUn {
	int nombreRoue;
	String marque;
	
	void afficherMaClass() {
		System.out.println("Je suis une " + marque);
		System.out.println("J'ai " + nombreRoue + " roues");
		//System.out.println();
	}

	public ClassJavaUn() {
	}

	public ClassJavaUn(int nombreRoue, String marque) {
		super();
		this.nombreRoue = nombreRoue;
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "ClassJavaUn [nombreRoue=" + nombreRoue + ", marque=" + marque + "]";
	}

	
	
}
