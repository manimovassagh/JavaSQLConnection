package io.mani.fahrrad;

import java.time.LocalDate;
import java.util.Objects;

public class Fahrrad {
	
	private int primaryKey;
	private String farbe;
	private String typ;
	private int groesse;
	private LocalDate verfugbarAb;
	
	
	@Override
	public String toString() {
		return "Fahrrad [primaryKey=" + primaryKey + ", farbe=" + farbe + ", typ=" + typ + ", groesse=" + groesse
				+ ", verfugbarAb=" + verfugbarAb + ", hashCode()=" + hashCode() + ", getPrimaryKey()=" + getPrimaryKey()
				+ ", getFarbe()=" + getFarbe() + ", getVerfugbarAb()=" + getVerfugbarAb() + ", getTyp()=" + getTyp()
				+ ", getGroesse()=" + getGroesse() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(farbe, groesse, typ);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fahrrad other = (Fahrrad) obj;
		return Objects.equals(farbe, other.farbe) && groesse == other.groesse && Objects.equals(typ, other.typ);
	}


	public Fahrrad( String farbe, String typ, int groesse, LocalDate verfugbarAb) {
		super();
		
		this.farbe = farbe;
		this.typ = typ;
		this.groesse = groesse;
		this.verfugbarAb = verfugbarAb;
	}


	public int getPrimaryKey() {
		return primaryKey;
	}


	public void setPrimaryKey(int primaryKey) {
		this.primaryKey = primaryKey;
	}


	public String getFarbe() {
		return farbe;
	}


	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}


	public LocalDate getVerfugbarAb() {
		return verfugbarAb;
	}


	public void setVerfugbarAb(LocalDate verfugbarAb) {
		this.verfugbarAb = verfugbarAb;
	}


	public String getTyp() {
		return typ;
	}


	public int getGroesse() {
		return groesse;
	}
		
	
	

}
