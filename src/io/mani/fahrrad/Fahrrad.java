package io.mani.fahrrad;

import java.time.LocalDate;

public class Fahrrad {
	
	private int primaryKey;
	private String farbe;
	private String typ;
	private int groesse;
	private LocalDate verfugbarAb;
	public Fahrrad( String farbe, String typ, int groesse, LocalDate verfugbarAb) {
		super();
		
		this.farbe = farbe;
		this.typ = typ;
		this.groesse = groesse;
		this.verfugbarAb = verfugbarAb;
	}
	
	
	

}
