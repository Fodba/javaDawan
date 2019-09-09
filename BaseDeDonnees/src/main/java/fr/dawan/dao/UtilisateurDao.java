package fr.dawan.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.dawan2.model.Utilisateur;

public class UtilisateurDao {
	
	// Methode CRUD
	// Une méthode insérer des donnees dans la base de données
	public static int inserer(Utilisateur u, Connection cnx, boolean fermerCnx) throws SQLException {
		String sqlInsertion = "INSERT INTO utilisateur "
				+ "(id,nom,prenom,adresse,telephone,login,password)"
				+ " VALUES(?,?,?,?,?,?,?)";
		
		PreparedStatement ps = cnx.prepareStatement(sqlInsertion);
		ps.setLong(1,  u.getId());
		ps.setString(1,  u.getNom());
		ps.setString(1,  u.getPrenom());
		ps.setString(1,  u.getAdresse());
		ps.setString(1,  u.getTelephone());
		ps.setString(1,  u.getLogin());
		ps.setString(1,  u.getPassword());
		
		int result = ps.executeUpdate();
		System.out.println(result);
		
		if(fermerCnx) {
			cnx.close();
		}
		
		return 0;
				
	}
	
	// Une méthode pour lire les données.
	
	// Une méthode pour mettre à jour les données.
	
	// Une méthode pour supprimerles données.
	
	
	
	
}
