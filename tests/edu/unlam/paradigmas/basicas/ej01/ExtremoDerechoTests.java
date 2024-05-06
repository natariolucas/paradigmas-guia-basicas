package edu.unlam.paradigmas.basicas.ej01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ExtremoDerechoTests {

	@Test
	void testValorIncluidoAbierto() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.ValorIncluido(0));
		assertTrue(extremo.ValorIncluido(-1));
	}
	
	@Test
	void testValoresNoIncluidosAbierto() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.ValorIncluido(1));
		assertFalse(extremo.ValorIncluido(2));
	}

	@Test
	void testValoresIncluidosCerrado() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.ValorIncluido(1));
		assertTrue(extremo.ValorIncluido(0));
		assertTrue(extremo.ValorIncluido(-1));
	}
	
	@Test
	void testValorNoIncluidoCerrado() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.ValorIncluido(2));
	}
}
