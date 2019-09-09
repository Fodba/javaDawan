package fr.dawan.ExoBaseDeDonnees;

import java.util.List;

import fr.dawan.dao.ProduitDao;
import fr.dawan.model.Produit;
import fr.dawan.utils.ConnexionBDD;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Produit u = new Produit();
    	u.setDescription("ma description du produit");
    	u.setPrix(55.99);
//    	
    	try {
    		ProduitDao.inserer(u, ConnexionBDD.getConnection(), true);
		} catch (Exception e) {
			System.out.println("Problème lors de la tentative d'insertion");
			System.out.println(e.getMessage());
		}
    	
    	try {
			List<Produit> ResultUsers = ProduitDao.lireToutTable( ConnexionBDD.getConnection(), true);

			for (Produit utilisateur : ResultUsers) {
				System.out.println(utilisateur);
			}
			
		} catch (Exception e) {
			System.out.println("Problème lors de la tentative de lecture");
			System.out.println(e.getMessage());
		}
    	
    	try {

			ProduitDao.supprimer(6, ConnexionBDD.getConnection(), true);
			
		} catch (Exception e) {
			System.out.println("Problème lors de la tentative d'insertion");
			System.out.println(e.getMessage());
		}
    	
    	
    	try {

			Produit produit = ProduitDao.lireParIdentifiant(4, ConnexionBDD.getConnection(), true);
			System.out.println(produit);
			
		} catch (Exception e) {
			System.out.println("Problème lors de la tentative de lecture d'un élément");
			System.out.println(e.getMessage());
		}
    }
}
