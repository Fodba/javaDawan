// commence par le package
package fr.dawan.rappelCours;

import java.io.Serializable;

// La liste des classes qu'on importe
// import de la classe Chat avec son chemin de pac
import fr.dawan.heritage.Chat;
// importer toutes classes présentent dans le do
//import fr.dawan.*;

// Convention JavaBean :
/*
 * AU moins un constructeur vide (sans paramètre)
 * et des getters/setters (public) pour tous les attributs private
 * classe doit implémenter l'interface Serializable
 */
// Interface Serializable 
/*
 * Un objet en mémoire est détruit à la fin de l'exécution du programme.  SI on souhaite conserver
 * ses états ou le transférer via un réseau; il faut que l'objet soit serialiser donc en implémentant
 * l'interface Serializable
 * 
 */
public class Rappel3 implements Serializable {

	// Grands principes de la POO (programmation orienté objet)
	// Agregation 
	Chat chat = new Chat();
	
	// Héritage
	/*
	 * Une classe peut hériter de tous les attributs et les méthodes d'une autre classe en utilisant le mot clé extends
	 * Dans les classes filles le mot clé super permet d'accéder aux attributs et aux méthodes de la classe mère
	 * On peut redéfinir les méthodes de la classe mère dans les classes filles (overriding)
	 * Une classe ne peut hérité que d'une seule classe (mais héritage en cascade autorisé)
	 * 
	 */
	
	
	// mot clé final
	/*
	 * sur une variable : ça permet de la rendre constante : final int NOM_MA_CONSTANTE = 10;
	 * sur une classe : elle ne pas avoir de classe fille
	 * sur les méthodes : ça permet d'empêcher la redéfinition dans les classes filles
	 * 
	 */
	
	// Polymorphisme
	/*
	 * Un objet peut prendre plusieurs formes
	 * On peut typer un objet avec une classe mère ou une interface
	 * Intérêt : - manipuler l'objet sans se soucier de son type
	 * 			 - mélanger des objets de différents types ( qui partagent une classe mère ou une interface)
	 * 
	 * Object tab[] = new Object[10];
	 * Si on veut manipuler les objets de ce tableau, on aura accès qu'aux méthodes et attributs du type du tableau
	 * Si on veut retrouver leur classe exacte, on peut tester le type d'un objet avec le mot clé instanceof
	 * 
	 * ex : if(valueTab instanceof Chat){
	 * 		Chat monChat = (chat) valueTab;
	 * 	}
	 * 
	 */
	
	
	// Abstraction : mot clé abstract
	/*
	 *  une classe abstraite  ne peut pas être instanciée
	 *  Dans une classe abstraite on peut avoir des méthodes abstraites : méthodes abstraites = juste la signature de la méthode
	 *  ex signature : public abstract void maMethode(int param1);
	 *  Toutes les classes filles qui héritent d'une classe abstraite doivent redéfinir les méthodes abstraites de la classe mère
	 */
	
	
	// Encapsulation : Mettre les attributs en visibilité private + génère les getters/setters public pour pouvoir contrôler les accès
	/*
	 * private : accessible uniquement dans la classe où ils sont déclarés
	 * public : accessible de partout
	 * protected : accessible uniquement dans la classe et ses classes filles
	 * default / ou rien mettre : accessible uniquement dans les classes du même package
	 * 
	 * Les facteurs de visibilité arrivent toujours en premier et peuvent sur des classes, sur des méthodes et des attributs
	 */
	
	
	// Interface : new interface ; et le mot clé pour implémenter une interface c'est implements
	// Une classe peut implémenter plusieurs interfaces
	/*
	 * Pseudo classe abstraite car on ne peut définir que des signatures de méthode à l'intérieur (sans utiliser le mot clé abstract)
	 * ex signature : public void maMethode(int param1);
	 * et on peut mettre des attributs constants (avec final)
	 * Une interface pour hériter d'une autre interface
	 * 
	 */
	
}
