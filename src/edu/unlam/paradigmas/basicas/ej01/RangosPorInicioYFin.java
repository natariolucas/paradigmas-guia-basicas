package edu.unlam.paradigmas.basicas.ej01;

import java.util.Comparator;

public class RangosPorInicioYFin implements Comparator<Rango>{

	

	@Override
	public int compare(Rango o1, Rango o2) {
		int diferenciaAIzquierda = compararAIzquierda(o1, o2);
		if (diferenciaAIzquierda != 0) {
			return diferenciaAIzquierda;
		}
		
		int diferenciaADerecha = compararADerecha(o1, o2);

		return diferenciaADerecha; // Si son iguales a derecha, y ya eran iguales a izquierda son iguales
	}

	private int compararAIzquierda(Rango o1, Rango o2) {
		int diferenciaAIzquierda = Double.compare(o1.getValorAIzquierda(), o2.getValorAIzquierda());
		
		if (diferenciaAIzquierda != 0) {
			return diferenciaAIzquierda;
		}
		// Mismo valor a izquierda, se resuelve por inclusión a izquierda
		
		if (o1.esCerradoAIzquierda() && o2.esAbiertoAIzquierda() ) {
			return -1;
		}
		
		if (o1.esAbiertoAIzquierda() && o2.esCerradoAIzquierda() ) {
			return 1;
		}
		
		return 0; // Ambos abiertos o ambos cerrados a izquierda
	}
	
	private int compararADerecha(Rango o1, Rango o2) {
		int diferenciaADerecha= Double.compare(o1.getValorADerecha(), o2.getValorADerecha());
		
		if (diferenciaADerecha != 0) {
			return diferenciaADerecha;
		}
		// Mismo valor a izquierda, se resuelve por inclusión a izquierda
		
		if (o1.esCerradoADerecha() && o2.esAbiertoADerecha() ) {
			return 1;
		}
		
		if (o1.esAbiertoADerecha() && o2.esCerradoADerecha() ) {
			return -1;
		}
		
		return 0; // Ambos abiertos o ambos cerrados a izquierda
	}
}
