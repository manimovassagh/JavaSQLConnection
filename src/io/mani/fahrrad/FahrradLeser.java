package io.mani.fahrrad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Demonstriert, wiesuaber lesend auf eine Datenbank zugegriffen werden kann
 * 
 * @author Alfa
 *
 */
public class FahrradLeser {

	public static final String VERBINDUNG = "jdbc:mysql://localhost:3306/fahrraederDB";
	public static final String USER = "root";
	public static final String PASSWORT = "";
	public static final String FAHRRAD_TABELLE = "Fahrrad";

	private List<Fahrrad> alleRaeder = new ArrayList<Fahrrad>();

	public void lesenFahrradTabelle() {
		//Try-with-resources: Geöffnete Verbindungen werde geschlossen, unabhängig von Exceptions
		try(Connection verbindungZurFahrradDB = DriverManager.getConnection(VERBINDUNG, USER, PASSWORT)){
		
			Statement verpackung  = verbindungZurFahrradDB.createStatement();
			String abfrage = "SELECT * FROM " + FAHRRAD_TABELLE;
			ResultSet ergebnisDerAbfrage = verpackung.executeQuery(abfrage);
			//System.out.println(ergebnisDerAbfrage);
			while(ergebnisDerAbfrage.next()) {
				int schluessel = ergebnisDerAbfrage.getInt("id");
				String farbe = ergebnisDerAbfrage.getString("farbe");
				String typ = ergebnisDerAbfrage.getString("typ");
				int groesse = ergebnisDerAbfrage.getInt("groesse");
				LocalDate verfuegbarAb = ergebnisDerAbfrage.getDate("verfuegbar_ab").toLocalDate();
				
				Fahrrad neuesRad = new Fahrrad(farbe, typ, groesse, verfuegbarAb);//Hier entsteht ein Fahrrad DTO
				neuesRad.setPrimaryKey(schluessel);
				//System.out.println(neuesRad);
				alleRaeder.add(neuesRad);
			}
			
		}catch(SQLException ausnahme) {
			System.out.println("Info an mich: Da klappt was nicht");
			ausnahme.printStackTrace();
		}
		//Hier ist die Verbindung zu!
	}

	/**
	 * @return the alleRaeder
	 */
	public List<Fahrrad> getAlleRaeder() {
		return alleRaeder;
	}

}
