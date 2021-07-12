package io.mani;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Mani Connection to SQL Through JSBC Diver
 * @param URL Connection {@value} user {@value} password
 */

public class LearnJDBC {

	public static void main(String[] args) throws Exception {

		String connectionURL = "jdbc:mysql://localhost:3306/testDBMontag?createDatabaseIfNotExist=true";
		String user = "root";
		String password = "";

		Connection connection = DriverManager.getConnection(connectionURL, user, password);
		System.out.println(connection);
		Statement statement = connection.createStatement();
		String DataRequest = "SELECT * FROM obst"; // Red all Data from the table in SQL
		ResultSet resultData = statement.executeQuery(DataRequest);
		System.out.println(resultData);
		
		
		// Read the ResultData
		while (resultData.next()) {
			// read The Loop per line
			int schluessel = resultData.getInt("obst_id");
			String farbe = resultData.getString("farbe");
			String sorte = resultData.getString(2); // index start in JDBC from 1 ! be carefull!!
			double preis = resultData.getDouble(4);
			System.out.println("Sorte " + sorte + " mit Farbe " + farbe + "kostet " + preis + " Euro" + " Bestellung nummer "
					+ schluessel );

		}
		resultData.first();
		System.out.println(resultData.getString("farbe"));
		resultData.next();
		System.out.println(resultData.getString("farbe"));
		

	}

}

