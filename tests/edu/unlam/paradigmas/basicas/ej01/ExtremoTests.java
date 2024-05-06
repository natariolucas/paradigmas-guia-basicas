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
}
