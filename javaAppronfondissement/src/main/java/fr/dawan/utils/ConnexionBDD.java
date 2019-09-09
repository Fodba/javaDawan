package fr.dawan.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnexionBDD {

	public static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		
//		// Classe pour charger les propriétés dans config.properties
//		Properties p = new Properties();
//		// Charge les propriétés du fichier config.properties dans p
//		p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
//		
		// ligne pour charger le driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//  Création de l'objet connection
		Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaamiens?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
		
		return cnx;
	}
}
