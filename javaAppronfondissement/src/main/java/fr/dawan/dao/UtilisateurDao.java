package fr.dawan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.model.Utilisateur;

public class UtilisateurDao {

	// Méthodes CRUD (create read update delete)
	// Une méthode pour insérer des données dans la base de données
	public static int inserer(Utilisateur u, Connection cnx, boolean fermerCnx) throws SQLException {
		
		// Création de la requête
		String sqlInsertion = "INSERT INTO utilisateur (id, nom, prenom, adresse, telephone, login, password) VALUES (?,?,?,?,?,?,?)";
		
		// Injecter les valeurs de notre objet à enregistrer en BDD dans la requête
		PreparedStatement ps = cnx.prepareStatement(sqlInsertion);
		
		// Injection des valeurs dans la requête à la place des ?
		ps.setInt(1, (int) u.getIdentifiant());
		ps.setString(2, u.getNom());
		ps.setString(3, u.getPrenom());
		ps.setString(4, u.getAdresse());
		ps.setString(5, u.getTelephone());
		ps.setString(6, u.getLogin());
		ps.setString(7, u.getPassword());
		
		// Execution de la requête
		int result = ps.executeUpdate();
		
		if(fermerCnx) {
			cnx.close();
		}

		return result;
		
	}
	
	// Une méthode pour lire les données
	public static List<Utilisateur> lireToutTable(Connection cnx, boolean fermerCnx) throws SQLException {
		String sql = "SELECT * FROM utilisateur";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Utilisateur> users = new ArrayList<Utilisateur>();
		
		while(rs.next()) {
			Utilisateur user = new Utilisateur();
			user.setIdentifiant(rs.getInt("id"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setAdresse(rs.getString("adresse"));
			user.setTelephone(rs.getString("telephone"));
			user.setLogin(rs.getString("login"));
			user.setPassword(rs.getString("password"));
			
			
			
			users.add(user);
		}

		if(fermerCnx) {
			cnx.close();
		}
		
		return users;
	}
	
	// Une méthode pour mettre à jour les données
	public static int modifier(Utilisateur u, Connection cnx, boolean fermerCnx) throws SQLException {
		String sql = "UPDATE utilisateur SET id=?, nom=?, prenom=?, adresse=?, telephone=?, login=?, password=? ";
		
		PreparedStatement ps = cnx.prepareStatement(sql);

		ps.setLong(1,  u.getIdentifiant());
		ps.setString(1,  u.getNom());
		ps.setString(1,  u.getPrenom());
		ps.setString(1,  u.getAdresse());
		ps.setString(1,  u.getTelephone());
		ps.setString(1,  u.getLogin());
		ps.setString(1,  u.getPassword());
		
		int result = ps.executeUpdate();


		if(fermerCnx) {
			cnx.close();
		}
		
		return result;
	}
	
	// Une méthode pour supprimer les données
	public static int supprimer(long id, Connection cnx, boolean fermerCnx) throws SQLException {

		String sql = "DELETE FROM utilisateur WHERE id=?";
		
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ps.setLong(1,  id);
		
		int rs = ps.executeUpdate();


		if(fermerCnx) {
			cnx.close();
		}
		
		return rs;
	}
	
}
