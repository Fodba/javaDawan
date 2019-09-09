// Une classe commence toujours par le package dans lequel elle se trouve
package fr.dawan.rappelCours;

// La classe principale doit toujours être public et est identifié par
// le mot clé class.
// Elle doit posséder le même nom que le fichier dans lequel elle se trouve, ici Rappel2
// Une classe est un modèle pour créer des objets ayant les même attributs et les mêmes métodes
// A partir d'une classe on peut créer/instancier des objets du type de la classe
// Chaque objet est une instance de la classe
public class Rappel2 {
// Corps de la classe
	
	// Attributs :   ils sont utilisables dans toutes les méthodes de la classe
	// Par défaut si on les initialise pas, ils sont initialisé par défaut
	
	// Variable d'instance (variable dont la valeur est propre  à l'objet/instance de la classe)
	// Pour accéder au variables d'instance à l'intérieur de la classe : directement soit par leur nom 
	// ou this.nomVariable (this fait référence à l'instance de la classe)
	// Pour y accéder depuis une autre classe (main par exemple) : nomObjet.nomVariable
	
	public int identifiant; // initialisé à 0
	public String nom; // initialisé à null
	private double decimaux; // initialisé 0.0
	public String prenom = "Jean";
	public boolean bool; // initialisé à false
	
	// Variable de classe (variable qui appartient à la classe et qui sera partagée par l'ensemble
	// des instances/objets de cette classe
	// mot clé static
	// Pour y accéder depuis l'intérieur de la classe : directement par leur nom soit NomClasse.nomVariable
	// Pour y accéder depuis une autre classe : NomClasse.nomVariableStatic
	static int nombreInstance;
	
	// Méthodes
	
	// Constructeur
	// Pas de type de retour, et doit porter le nom exacte de la classe
	// Si on a aucun constructeur => un constructeur vide par défaut
	Rappel2(){ // Constructeur vide
		
	}
	
	// Constructeur surchargé
	Rappel2(int id, String nom) {
		this.identifiant = id;
		this.nom = nom;
	}
	
	// Méthode d'instance (méthodes qui sont propres aux isntances de la classe)
	// TypeRetour NomMethode (int param1, String param2, .... )
	public int methode1(int param1, String parma2) { // fonction
		
		// Creer des variables locales et les manipuler
		int maVariableLocale = 0;
		
		// Appel à d'autres méthodes
		
		// mot clé return o=pour ce que la méthode va renvoyer lorsqu'on appel cette méthode
		return 0;
	}
	
	// Méthode surchargée
	public void methode1(int param1, String parma2, int param3) { // procédure


	}
	
	// Méthode de classe (elles appartiennent à la classe)
	// Elles sont identifiées par le mot clé static
	// On ne peut manipuler que dezs attributs static (de classe) et faire des appels à des méthodes static (de classe)
	public static void afficherNombre() {
		exempleStatic();
	}
	
	public static void exempleStatic() {
		
	}
	
}
