package edu.unlam.paradigmas.basicas.ej01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExtremoTests {

	@Test
	void testInicializarExtremoAbierto() {
		Extremo extremo = new Extremo(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
	}

	@Test
	void testInicializarExtremoCerrado() {
		Extremo extremo = new Extremo(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
	}
	
	@Test
	void testComparacionExtremosCerradosIguales() {
		Extremo extremo = new Extremo(1, true);
		Extremo otroExtremo = new Extremo(1, true);
		
		assertEquals(0, extremo.compararValor(otroExtremo));
	}
	
	@Test
	void testComparacionExtremosAbiertosIguales() {
		Extremo extremo = new Extremo(1, false);
		Extremo otroExtremo = new Extremo(1, false);
		
		assertEquals(0, extremo.compararValor(otroExtremo));
	}
	
	@Test
	void testComparacionExtremosNoIgualesMismoValor() {
		Extremo extremo = new Extremo(1, true);
		Extremo otroExtremo = new Extremo(1, false);
		
		assertEquals(0, extremo.compararValor(otroExtremo));
		assertEquals(0, otroExtremo.compararValor(extremo));
	}
	
	@Test
	void testComparacionExtremosMayorMenor() {
		Extremo extremo = new Extremo(2, true);
		Extremo otroExtremo = new Extremo(1, true);
		
		assertTrue(extremo.compararValor(otroExtremo) > 0 );
		assertTrue(otroExtremo.compararValor(extremo) < 0 );
	}
}
