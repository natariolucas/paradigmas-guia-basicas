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
		
		assertTrue(extremo.incluyeValor(2));
	}
	
	@Test
	void testValoresNoIncluidosAbierto() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		
		assertTrue(extremo.esAbierto());
		assertFalse(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.incluyeValor(1));
		assertFalse(extremo.incluyeValor(0));
		assertFalse(extremo.incluyeValor(-1));
	}

	@Test
	void testValoresIncluidosCerrado() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertTrue(extremo.incluyeValor(2));
		assertTrue(extremo.incluyeValor(1));
	}
	
	@Test
	void testValorNoIncluidoCerrado() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.esAbierto());
		assertTrue(extremo.esCerrado());
		assertEquals(1, extremo.getValor());
		
		assertFalse(extremo.incluyeValor(-1));
		assertFalse(extremo.incluyeValor(0));
	}
	
	@Test
	void testMismoExtremoCerradoNoIncluido() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		ExtremoIzquierdo otro = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.incluyeExtremo(otro));
		assertFalse(otro.incluyeExtremo(extremo));
	}
	
	@Test
	void testMismoExtremoAbiertoNoIncluido() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		ExtremoIzquierdo otro = new ExtremoIzquierdo(1, false);
		
		assertFalse(extremo.incluyeExtremo(otro));
		assertFalse(otro.incluyeExtremo(extremo));
	}
	
	@Test
	void testExtremosCerradosDistintosInclusion() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		ExtremoIzquierdo otro = new ExtremoIzquierdo(2, true);
		
		assertTrue(extremo.incluyeExtremo(otro));
		assertFalse(otro.incluyeExtremo(extremo));
	}
	
	@Test
	void testExtremosAbiertosDistintosInclusion() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		ExtremoIzquierdo otro = new ExtremoIzquierdo(2, false);
		
		assertTrue(extremo.incluyeExtremo(otro));
		assertFalse(otro.incluyeExtremo(extremo));
	}
	
	@Test
	void testExtremosMismoValorDistintaCondicionInclusion() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		ExtremoIzquierdo otro = new ExtremoIzquierdo(1, false);
		
		boolean incluye = extremo.incluyeExtremo(otro);
		assertTrue(incluye);
		assertFalse(otro.incluyeExtremo(extremo));
	}
	
	@Test
	void testIncluyeExtremosCerradosIguales() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		ExtremoIzquierdo otroExtremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.incluyeExtremo(otroExtremo));
	}
	
	@Test
	void testIncluyeExtremosAbiertosIguales() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, false);
		ExtremoIzquierdo otroExtremo = new ExtremoIzquierdo(1, false);
		
		assertFalse(extremo.incluyeExtremo(otroExtremo));
	}
	
	@Test
	void testIncluyeExtremosNoIgualesMismoValor() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(1, true);
		ExtremoIzquierdo otroExtremo = new ExtremoIzquierdo(1, false);
		
		assertTrue(extremo.incluyeExtremo(otroExtremo));
		assertFalse(otroExtremo.incluyeExtremo(extremo));
	}
	
	@Test
	void testIncluyeExtremosMayorMenor() {
		ExtremoIzquierdo extremo = new ExtremoIzquierdo(2, true);
		ExtremoIzquierdo otroExtremo = new ExtremoIzquierdo(1, true);
		
		assertFalse(extremo.incluyeExtremo(otroExtremo));
		assertTrue(otroExtremo.incluyeExtremo(extremo));
	}

}
