package fr.dawan.javaAppronfondissement;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import fr.dawan.dao.UtilisateurDao;
import fr.dawan.model.Utilisateur;
import fr.dawan.utils.ConnexionBDD;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	Utilisateur u = new Utilisateur();
    	u.setAdresse("monAdresse");
    	u.setLogin("Arnaud");
    	u.setNom("Delafont");
    	u.setPassword("pswd");
    	u.setPrenom("Arnaud");
    	u.setTelephone("012222222222");
    	
    	try {
			UtilisateurDao.inserer(u, ConnexionBDD.getConnection(), true);
			List<Utilisateur> ResultUsers = UtilisateurDao.lireToutTable( ConnexionBDD.getConnection(), true);
			
			
			UtilisateurDao.supprimer(12, ConnexionBDD.getConnection(), true);
			

			for (Utilisateur utilisateur : ResultUsers) {
				System.out.println(utilisateur);
			}
		} catch (Exception e) {
			System.out.println("Problème lors de la tentative d'insertion");
		} 
    }
}
