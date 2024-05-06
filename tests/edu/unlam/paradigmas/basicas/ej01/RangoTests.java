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
		assertTrue(rango.ValorIncluido(1)); // Extremo izquierdo
		assertTrue(rango.ValorIncluido(3)); // Extremo derecho
		assertTrue(rango.ValorIncluido(1.0001));
		assertTrue(rango.ValorIncluido(2.99999));
		
		// No incluidos
		assertFalse(rango.ValorIncluido(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.ValorIncluido(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.ValorIncluido(0));
		assertFalse(rango.ValorIncluido(4));
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
		assertTrue(rango.ValorIncluido(1.0001));
		assertTrue(rango.ValorIncluido(2.99999));
		
		// No incluidos
		assertFalse(rango.ValorIncluido(1)); // Extremo izquierdo
		assertFalse(rango.ValorIncluido(3)); // Extremo derecho
		assertFalse(rango.ValorIncluido(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.ValorIncluido(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.ValorIncluido(0));
		assertFalse(rango.ValorIncluido(4));
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
		assertTrue(rango.ValorIncluido(1)); // Extremo izquierdo
		assertTrue(rango.ValorIncluido(1.0001));
		assertTrue(rango.ValorIncluido(2.99999));
		
		// No incluidos
		assertFalse(rango.ValorIncluido(3)); // Extremo derecho
		assertFalse(rango.ValorIncluido(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.ValorIncluido(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.ValorIncluido(0));
		assertFalse(rango.ValorIncluido(4));
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
		assertTrue(rango.ValorIncluido(3)); // Extremo derecho
		assertTrue(rango.ValorIncluido(1.0001));
		assertTrue(rango.ValorIncluido(2.99999));
		
		// No incluidos
		assertFalse(rango.ValorIncluido(1)); // Extremo izquierdo
		assertFalse(rango.ValorIncluido(0.999999)); // Cerano a extremo izquierdo
		assertFalse(rango.ValorIncluido(3.0000001)); // Cercano a extremo derecho
		assertFalse(rango.ValorIncluido(0));
		assertFalse(rango.ValorIncluido(4));
	}
	
}
