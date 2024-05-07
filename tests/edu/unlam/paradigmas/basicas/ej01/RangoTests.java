package edu.unlam.paradigmas.basicas.ej01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RangoTests {

	/**
	 * 
	 * Tests de rango cerrado  
	 * 
	 * */
	
	@Test
	void TestCrearRangoCerrado() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		
		assertTrue(rango.esCerrado());
		assertTrue(rango.esCerradoAIzquierda());
		assertTrue(rango.esCerradoADerecha());
		
		assertFalse(rango.esAbierto());
		assertFalse(rango.esAbiertoAIzquierda());
		assertFalse(rango.esAbiertoADerecha());
	}
	
	@Test
	void TestValoresRangoCerrado() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		
		// Incluidos 
		assertTrue(rango.incluyeValor(1)); // Extremo izquierdo
		assertTrue(rango.incluyeValor(3)); // Extremo derecho
		assertTrue(rango.incluyeValor(1.0001));
		assertTrue(rango.incluyeValor(2.99999));
		
		// No incluidos
		assertFalse(rango.incluyeValor(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.incluyeValor(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.incluyeValor(0));
		assertFalse(rango.incluyeValor(4));
	}
	
	/**
	 * 
	 * Tests de rango abierto  
	 * 
	 * */
	
	@Test
	void TestCrearRangoAbierto() {
		Rango rango = Rango.NewRangoAbierto(1, 3);
		
		assertFalse(rango.esCerrado());
		assertFalse(rango.esCerradoAIzquierda());
		assertFalse(rango.esCerradoADerecha());
		
		assertTrue(rango.esAbierto());
		assertTrue(rango.esAbiertoAIzquierda());
		assertTrue(rango.esAbiertoADerecha());
	}
	
	@Test
	void TestValoresRangoAbierto() {
		Rango rango = Rango.NewRangoAbierto(1, 3);
		
		// Incluidos 
		assertTrue(rango.incluyeValor(1.0001));
		assertTrue(rango.incluyeValor(2.99999));
		
		// No incluidos
		assertFalse(rango.incluyeValor(1)); // Extremo izquierdo
		assertFalse(rango.incluyeValor(3)); // Extremo derecho
		assertFalse(rango.incluyeValor(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.incluyeValor(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.incluyeValor(0));
		assertFalse(rango.incluyeValor(4));
	}
	
	/**
	 * 
	 * Tests de rango cerrado a izquierda
	 * 
	 * */
	
	@Test
	void TestCrearRangoCerradoAIzquierda() {
		Rango rango = Rango.NewRangoCerradoAIzquierda(1,3);
		
		assertFalse(rango.esCerrado());
		assertTrue(rango.esCerradoAIzquierda());
		assertFalse(rango.esCerradoADerecha());
		
		assertFalse(rango.esAbierto());
		assertFalse(rango.esAbiertoAIzquierda());
		assertTrue(rango.esAbiertoADerecha());
	}
	
	@Test
	void TestValoresRangoCerradoAIzquierda() {
		Rango rango = Rango.NewRangoCerradoAIzquierda(1, 3);
		
		// Incluidos 
		assertTrue(rango.incluyeValor(1)); // Extremo izquierdo
		assertTrue(rango.incluyeValor(1.0001));
		assertTrue(rango.incluyeValor(2.99999));
		
		// No incluidos
		assertFalse(rango.incluyeValor(3)); // Extremo derecho
		assertFalse(rango.incluyeValor(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.incluyeValor(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.incluyeValor(0));
		assertFalse(rango.incluyeValor(4));
	}

	/**
	 * 
	 * Tests de rango cerrado a derecha
	 * 
	 * */
	
	@Test
	void TestCrearRangoCerradoADerecha() {
		Rango rango = Rango.NewRangoCerradoADerecha(1,3);
		
		assertFalse(rango.esCerrado());
		assertFalse(rango.esCerradoAIzquierda());
		assertTrue(rango.esCerradoADerecha());
		
		assertFalse(rango.esAbierto());
		assertTrue(rango.esAbiertoAIzquierda());
		assertFalse(rango.esAbiertoADerecha());
	}
	
	@Test
	void TestValoresRangoCerradoADerecha() {
		Rango rango = Rango.NewRangoCerradoADerecha(1, 3);
		
		// Incluidos 
		assertTrue(rango.incluyeValor(3)); // Extremo derecho
		assertTrue(rango.incluyeValor(1.0001));
		assertTrue(rango.incluyeValor(2.99999));
		
		// No incluidos
		assertFalse(rango.incluyeValor(1)); // Extremo izquierdo
		assertFalse(rango.incluyeValor(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.incluyeValor(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.incluyeValor(0));
		assertFalse(rango.incluyeValor(4));
	}
	
	/**
	 * Test de inclusion de rango
	 * */
	
	@Test
	void TestRangoIncluidoCerradoYAbierto() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoAbierto(1, 3);
		
		assertTrue(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
		
	}
	
	@Test
	void TestRangoNoIncluidoAmbosCerrados() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(1, 3);
		
		assertTrue(rango.incluyeRango(otro));
		assertTrue(otro.incluyeRango(rango));
	}
	
	@Test
	void TestRangoIncluidoAmbosAbiertos() {
		Rango rango = Rango.NewRangoAbierto(1, 3);
		Rango otro = Rango.NewRangoAbierto(1, 3);
		
		assertTrue(rango.incluyeRango(otro));
		assertTrue(otro.incluyeRango(rango));
	}
	
	@Test
	void TestRangoNoIncluidoParcialmente() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(-1, 2);
		
		assertFalse(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
	}
	
	@Test
	void TestRangoNoIncluido() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(4, 5);
		
		assertFalse(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
	}
	
	@Test
	void TestRangoNoIntersecta() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(4, 5);
		
		assertFalse(rango.intersectaRango(otro));
		assertFalse(otro.intersectaRango(rango));
	}
	
	@Test
	void TestRangoIntersectaDerecha() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(-1, 2);
		
		assertTrue(rango.intersectaRango(otro));
		assertTrue(otro.intersectaRango(rango));
	}
	
	@Test
	void TestRangoIntersectaIzquierda() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(2, 5);
		
		assertTrue(rango.intersectaRango(otro));
		assertTrue(otro.intersectaRango(rango));
	}
	
	@Test
	void TestRangoIntersectaCompleto() {
		Rango rango = Rango.NewRangoCerrado(1, 5);
		Rango otro = Rango.NewRangoCerrado(2, 3);
		
		assertTrue(rango.intersectaRango(otro));
		assertTrue(otro.intersectaRango(rango));
	}

	@Test
	void TestRangoIntersectaIguales() {
		Rango rango = Rango.NewRangoCerrado(1, 2);
		Rango otro = Rango.NewRangoCerrado(1, 2);
		
		assertTrue(rango.intersectaRango(otro));
		assertTrue(otro.intersectaRango(rango));
	}
	
	@Test
	void TestRangosIguales() {
		Rango rango = Rango.NewRangoCerrado(1, 2);
		Rango otro = Rango.NewRangoCerrado(1, 2);
		
		assertTrue(rango.equals(otro));
		assertTrue(otro.equals(rango));
	}
	
	@Test
	void TestRangosDistintos() {
		Rango rango = Rango.NewRangoAbierto(3, 4);
		Rango otro = Rango.NewRangoCerrado(1, 2);
		
		assertFalse(rango.equals(otro));
		assertFalse(otro.equals(rango));
	}
	
	@Test
	void TestRangosIgualValorDistintaIclusion() {
		Rango rango = Rango.NewRangoAbierto(1, 2);
		Rango otro = Rango.NewRangoCerrado(1, 2);
		
		assertFalse(rango.equals(otro));
		assertFalse(otro.equals(rango));
	}
	
	@Test
	void TestOrdenRangosMismoValor() {
		Rango r1 = Rango.NewRangoAbierto(1, 2);
		Rango r2 = Rango.NewRangoCerrado(1, 2);
		
		Rango[] conjuntoDesordenado = new Rango[] {r1, r2};
		Arrays.sort(conjuntoDesordenado, new RangosPorInicioYFin());

		Rango[] conjuntoOrdenado = new Rango[] {r2, r1};
		
		assertArrayEquals(conjuntoOrdenado, conjuntoDesordenado);
	}
	
	@Test
	void TestOrdenRangosDistintoValor() {
		Rango r1 = Rango.NewRangoCerrado(-10, 2);
		Rango r2 = Rango.NewRangoCerrado(1, 2);
		Rango r3 = Rango.NewRangoCerrado(3, 4);
		
		Rango[] conjuntoDesordenado = new Rango[] {r3, r2, r1};
		Arrays.sort(conjuntoDesordenado, new RangosPorInicioYFin());

		Rango[] conjuntoOrdenado = new Rango[] {r1, r2,r3};
		
		assertArrayEquals(conjuntoOrdenado, conjuntoDesordenado);
	}

	@Test
	void TestOrdenRangosDesempataPorFin() {
		Rango r1 = Rango.NewRangoCerradoAIzquierda(0, 2);
		Rango r2 = Rango.NewRangoCerradoAIzquierda(0, 20);
		Rango r3 = Rango.NewRangoCerradoAIzquierda(0, 50);
		
		Rango[] conjuntoDesordenado = new Rango[] {r3, r1, r2};
		Arrays.sort(conjuntoDesordenado, new RangosPorInicioYFin());

		Rango[] conjuntoOrdenado = new Rango[] {r1, r2,r3};
		
		assertArrayEquals(conjuntoOrdenado, conjuntoDesordenado);
	}
	
	@Test
	void TestOrdenRangosDesempataPorFinDistintaInclusion() {
		Rango r1 = Rango.NewRangoCerradoAIzquierda(0, 2);
		Rango r2 = Rango.NewRangoCerradoAIzquierda(0, 20);
		Rango r3 = Rango.NewRangoCerrado(0, 20);
		
		Rango[] conjuntoDesordenado = new Rango[] {r3, r1, r2};
		Arrays.sort(conjuntoDesordenado, new RangosPorInicioYFin());

		Rango[] conjuntoOrdenado = new Rango[] {r1, r2,r3};
		
		assertArrayEquals(conjuntoOrdenado, conjuntoDesordenado);
	}
	
	@Test
	void TestRangoCerradoToString() {
		Rango r1 = Rango.NewRangoCerrado(1.344, 2.898);
		
		assertEquals("[1.344,2.898]", r1.toString());
	}
	
	@Test
	void TestRangoAbiertoToString() {
		Rango r1 = Rango.NewRangoAbierto(1.344, 2.898);
		
		assertEquals("(1.344,2.898)", r1.toString());
	}
	
	@Test
	void TestRangoCerradoAIzquierdaToString() {
		Rango r1 = Rango.NewRangoCerradoAIzquierda(1.344, 2.898);
		
		assertEquals("[1.344,2.898)", r1.toString());
	}
	
	@Test
	void TestRangoCerradoADerechaToString() {
		Rango r1 = Rango.NewRangoCerradoADerecha(1.344, 2.898);
		
		assertEquals("(1.344,2.898]", r1.toString());
	}
	
	@Test
	void TestRangoAbarcativoCerrado() {
		Rango r1 = Rango.NewRangoCerrado(1,2);
		Rango r2 = Rango.NewRangoCerrado(-3,2);
		Rango r3 = Rango.NewRangoCerrado(1,5);
		Rango r4 = Rango.NewRangoCerradoADerecha(-1,10);
		Rango r5 = Rango.NewRangoCerradoAIzquierda(-1,10);
		
		Rango[] rangos = new Rango[] {r1,r2,r3, r4, r5};
		
		Rango abarcativo = Rango.NewRangoCerrado(-3, 10);
		
		assertEquals(abarcativo, Rango.NewRangoAbarcativo(rangos));
	}
	
	@Test
	void TestRangoAbarcativoAbierto() {
		Rango r1 = Rango.NewRangoCerrado(1,2);
		Rango r2 = Rango.NewRangoAbierto(-3,2);
		Rango r3 = Rango.NewRangoCerrado(1,5);
		Rango r4 = Rango.NewRangoCerradoADerecha(-1,9);
		Rango r5 = Rango.NewRangoAbierto(-1,10);
		
		Rango[] rangos = new Rango[] {r1,r2,r3, r4, r5};
		
		Rango abarcativo = Rango.NewRangoAbierto(-3, 10);
		
		assertEquals(abarcativo, Rango.NewRangoAbarcativo(rangos));
	}
	
	
}
