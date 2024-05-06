package edu.unlam.paradigmas.basicas.ej01;

import static org.junit.jupiter.api.Assertions.*;

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
		
		assertFalse(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
		
	}
	
	@Test
	void TestRangoNoIncluidoAmbosAbiertos() {
		Rango rango = Rango.NewRangoAbierto(1, 3);
		Rango otro = Rango.NewRangoAbierto(1, 3);
		
		assertFalse(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
		
	}
	
	@Test
	void TestRangoNoIncluidoParcialmente() {
		Rango rango = Rango.NewRangoCerrado(1, 3);
		Rango otro = Rango.NewRangoCerrado(-1, 2);
		
		assertFalse(rango.incluyeRango(otro));
		assertFalse(otro.incluyeRango(rango));
		
	}
	
}
