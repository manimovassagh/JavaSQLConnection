package io.mani.fahrrad;

import java.util.List;

public class FahrradMainTest {

	public static void main(String[] args) {
		FahrradLeser leser = new FahrradLeser();
		leser.lesenFahrradTabelle();
		List<Fahrrad> alleBeike = leser.getAlleRaeder();
		alleBeike.forEach(rad -> System.out.println(rad));

		
	}

}
