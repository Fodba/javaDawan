package fr.dawan.rappelCours;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Rappel4 {

	// Classe Object
	// Toutes les classes en héritent implicitement ce qui donne à toutes les classes l'accès aux méthodes
	// suivantes qu'il faut redéfinir dans chaque classe qu'on va créer (on peut toutes les
	// générer automatiquement en faisant (source > generate ...)
				// object.toString() : retourne sous la forme d'une string la représentation
						// de l'objet avec les valeurs de ces attributs 
				// objet.equals(objetAComparer) & hashcode() : permet de tester
						// l'égalité entre deux objets du même type (même classe)
						// Attention pas confondre avec l'opérateur == qui permet de tester l'égalité des types primitifs
	
	// Classe String
	// Les String sont non mutables : Une fois créé dans la zone mémoire (pour les String StringPool)
	// elles ne sont plus modifiables en mémoire (transparent côté code) 
	// = à chaque fois qu'on modifie directement une String, le programme va créer plusieurs string en mémoire = pas du tout optimisé
	
	public static void main(String[] args) {
		String maString = "exemple"; // en zone mémoire "exemple"
		maString = maString.concat(" coucou"); // en zone mémoire il va créer " coucou" et "exemple coucou"
	// equivalent pour la concaténation : maString + " coucou"
		
		// Classe utilitaire StringBuilder
		StringBuilder maStringViaStringBuilder = new StringBuilder("exemple");
		// .append du StringBuilder equivalent .concat du String
		maStringViaStringBuilder.append(" coucou");
		// pour le retrouver sous forme de String utiliser .toString()
		maStringViaStringBuilder.toString();
		
		
		// Les Exceptions 
		// C'est un évènement qui va stopper l'exécution de mon programme
		
		// essaye de m'exécuter le code qui est susceptible de me générer une excetion
		try {
			int result = 10 / 0;
		} 
		// Attrape l'exception généré dans le try
		catch(ArithmeticException e) {
			System.out.println("Opération arithmétique interdite");
		}
		catch(Exception e) {
			System.out.println("Exception g");
		}
		// Optionnel : code toujours exécuté
		finally {
			System.out.println("je suis toujours ex");
		}	
		
		
		try {
			exempleException();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	// mot clé throw pour jeter manuellement une exception
	// mot clé throws sur la signature de la méthode pour préciser que cette méthode
	// est susceptible de générer une exception
	public static void exempleException() throws Exception {
		
		throw new Exception();
	}
	
	// Collection : c'est un tableau dynamique
	public static void exempleCollection() {
		
		// Convention : déclarer une collection avec l'interface correspondante et l'initialise
		// avec une des classes qui implémentent l'interface : la collection qu'on aura déclarer avec l'interface
		// aura juste accès aux méthodes de l'interface, si jamais on veut changer le type avec lequel on a initialisé
		// on aura juste à modifier le type utilisé dans la déclaration
		
		// Déclaration
		List<String> maListe;
		
		// Initialisation
		maListe = new ArrayList<String>();
		
		maListe.add("monpremierElement");
		System.out.println(maListe.get(0));
		
		// Si vous voulez avoir accès aux méthode de ArrayList il faudra caster / convertir la liste
		//(ArrayList<String>) maListe.maMethodeDeArrayList();
		
		// Set (interface) c'est exactement la même chose que les liste sauf qu'on ne peut pas avoir doublon
		Set<String> monSet = new HashSet<String>();
		
		// Map (interface) permet d'associer à chaque variable une clé
		// Pour récupérer ensuite la variable dans la map on utilise la clé qui lui est associé
		// Map<Clé, Valeur>
		Map<String, Utilisateur> maMap = new HashMap<String, Utilisateur>();
		// Met des éléments dans ma map
		maMap.put("login1", new Utilisateur());	
		// Je récupère mon élément via sa clé
		maMap.get("login1");
		
	}
	
}
