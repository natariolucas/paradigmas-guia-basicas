package edu.unlam.paradigmas.basicas.ej01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExtremoIzquierdoTests {
	
	@Test
	void testValorIncluidoAbierto() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.ValorIncluido(2));
	}
	
	@Test
	void testValoresNoIncluidosAbierto() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.ValorIncluido(1));
		assertFalse(extremo.ValorIncluido(0));
		assertFalse(extremo.ValorIncluido(-1));
	}

	@Test
	void testValoresIncluidosCerrado() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.ValorIncluido(2));
		assertTrue(extremo.ValorIncluido(1));
	}
	
	@Test
	void testValorNoIncluidoCerrado() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.ValorIncluido(-1));
		assertFalse(extremo.ValorIncluido(0));
	}

}
