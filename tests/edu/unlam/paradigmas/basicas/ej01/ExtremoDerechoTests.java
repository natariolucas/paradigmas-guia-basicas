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
		
		assertTrue(extremo.incluyeValor(0));
		assertTrue(extremo.incluyeValor(-1));
	}
	
	@Test
	void testValoresNoIncluidosAbierto() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.incluyeValor(1));
		assertFalse(extremo.incluyeValor(2));
	}

	@Test
	void testValoresIncluidosCerrado() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.incluyeValor(1));
		assertTrue(extremo.incluyeValor(0));
		assertTrue(extremo.incluyeValor(-1));
	}
	
	@Test
	void testValorNoIncluidoCerrado() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.incluyeValor(2));
	}
	
	@Test
	void testIncluyeExtremosCerradosIguales() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		ExtremoDerecho otroExtremo = new ExtremoDerecho(1, true);
		
		assertFalse(extremo.incluyeExtremo(otroExtremo));
	}
	
	@Test
	void testIncluyeExtremosAbiertosIguales() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, false);
		ExtremoDerecho otroExtremo = new ExtremoDerecho(1, false);
		
		assertFalse(extremo.incluyeExtremo(otroExtremo));
	}
	
	@Test
	void testIncluyeExtremosNoIgualesMismoValor() {
		ExtremoDerecho extremo = new ExtremoDerecho(1, true);
		ExtremoDerecho otroExtremo = new ExtremoDerecho(1, false);
		
		assertTrue(extremo.incluyeExtremo(otroExtremo));
		assertFalse(otroExtremo.incluyeExtremo(extremo));
	}
	
	@Test
	void testIncluyeExtremosMayorMenor() {
		ExtremoDerecho extremo = new ExtremoDerecho(2, true);
		ExtremoDerecho otroExtremo = new ExtremoDerecho(1, true);
		
		assertTrue(extremo.incluyeExtremo(otroExtremo));
		assertFalse(otroExtremo.incluyeExtremo(extremo));
	}
}
