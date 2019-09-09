package fr.dawan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.dawan.model.Produit;

public class ProduitDao {

	// Méthodes CRUD (create read update delete)
	// Une méthode pour insérer des données dans la base de données
	public static int inserer(Produit u, Connection cnx, boolean fermerCnx) throws SQLException {
		
		// Création de la requête
		String sqlInsertion = "INSERT INTO produit (description, prix) VALUES (?,?)";
		
		// Injecter les valeurs de notre objet à enregistrer en BDD dans la requête
		PreparedStatement ps = cnx.prepareStatement(sqlInsertion);
		
		// Injection des valeurs dans la requête à la place des ?
		//ps.setLong(1, (long) u.getId());
		ps.setString(1, u.getDescription());
		ps.setDouble(2, u.getPrix());
		
		// Execution de la requête
		int result = ps.executeUpdate();
		
		if(fermerCnx) {
			cnx.close();
		}

		return result;
		
	}
	
	// Une méthode pour lire les données
	public static List<Produit> lireToutTable(Connection cnx, boolean fermerCnx) throws SQLException {
		String sql = "SELECT * FROM produit";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Produit> users = new ArrayList<Produit>();
		
		while(rs.next()) {
			Produit user = new Produit();
			
			user.setId(rs.getLong("id"));
			user.setDescription(rs.getString("description"));
			user.setPrix(rs.getDouble("prix"));
		}

		if(fermerCnx) {
			cnx.close();
		}
		
		return users;
	}
	
	// Une méthode pour mettre à jour les données
	public static int modifier(Produit u, Connection cnx, boolean fermerCnx) throws SQLException {
		String sql = "UPDATE produit SET description=?, prix=? WHERE id=?";
		
		PreparedStatement ps = cnx.prepareStatement(sql);

		ps.setLong(3,  u.getId());
		ps.setString(1,  u.getDescription());
		ps.setDouble(2,  u.getPrix());
		
		int result = ps.executeUpdate();


		if(fermerCnx) {
			cnx.close();
		}
		
		return result;
	}
	
	// Une méthode pour supprimer les données
	public static int supprimer(int id, Connection cnx, boolean fermerCnx) throws SQLException {

		String sql = "DELETE FROM produit WHERE id=?";
		
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ps.setLong(1,  id);
		
		int rs = ps.executeUpdate();


		if(fermerCnx) {
			cnx.close();
		}
		
		return rs;
	}
	
	// Méthode pour récupérer un element par son id.
	public static Produit lireParIdentifiant(int id, Connection cnx, boolean fermerCnx) throws SQLException {
		String sql = "SELECT * FROM produit WHERE id=?";
		PreparedStatement ps = cnx.prepareStatement(sql);
		
		ps.setLong(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		Produit user = new Produit();
		rs.next();

		//while(rs.next()) {
			user.setId(rs.getLong("id"));
			user.setDescription(rs.getString("description"));
			user.setPrix(rs.getDouble("prix"));	
		//}

		if(fermerCnx) {
			cnx.close();
		}
		
		return user;
	}
	
	
	
}
