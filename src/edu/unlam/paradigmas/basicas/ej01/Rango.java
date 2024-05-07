package edu.unlam.paradigmas.basicas.ej01;

import java.util.Objects;

public class Rango {
	private ExtremoIzquierdo extremoIzquierdo;
	private ExtremoDerecho extremoDerecho;

	private Rango(boolean cerradoAIzquierda, double extremoIzquierda, boolean cerradoADerecha, Double extremoDerecha) {
		if (Double.compare(extremoIzquierda, extremoDerecha) > 0) { // Fallback, deberia ser excepción
			this.extremoIzquierdo = new ExtremoIzquierdo(extremoDerecha, cerradoADerecha);
			this.extremoDerecho = new ExtremoDerecho(extremoIzquierda, cerradoAIzquierda);
		} else {
			this.extremoIzquierdo = new ExtremoIzquierdo(extremoIzquierda, cerradoAIzquierda);
			this.extremoDerecho = new ExtremoDerecho(extremoDerecha, cerradoADerecha);
		}

	}

	public static Rango NewRangoCerrado(double extremoIzquierda, double extremoDerecha) {
		return new Rango(true, extremoIzquierda, true, extremoDerecha);
	}

	public static Rango NewRangoCerradoAIzquierda(double extremoIzquierda, double extremoDerecha) {
		return new Rango(true, extremoIzquierda, false, extremoDerecha);
	}

	public static Rango NewRangoCerradoADerecha(double extremoIzquierda, double extremoDerecha) {
		return new Rango(false, extremoIzquierda, true, extremoDerecha);
	}

	public static Rango NewRangoAbierto(double extremoIzquierda, double extremoDerecha) {
		return new Rango(false, extremoIzquierda, false, extremoDerecha);
	}
	
	public boolean incluyeValor(double valor ) {
		return this.extremoIzquierdo.incluyeValor(valor) && this.extremoDerecho.incluyeValor(valor);
	}
	
	public boolean incluyeRango(Rango otro) {
		return this.extremoIzquierdo.incluyeExtremo(otro.extremoIzquierdo) && 
				this.extremoDerecho.incluyeExtremo(otro.extremoDerecho);
	}

	public boolean intersectaRango(Rango otro) {
		return 
				( this.extremoIzquierdo.incluyeExtremo(otro.extremoIzquierdo) && this.extremoDerecho.incluyeExtremo(otro.extremoIzquierdo) ) ||
				( this.extremoIzquierdo.incluyeExtremo(otro.extremoDerecho) && this.extremoDerecho.incluyeExtremo(otro.extremoDerecho) ) ||
				otro.incluyeRango(this);
	}
	

	public boolean esCerrado() {
		return this.esCerradoAIzquierda() && this.esCerradoADerecha();
	}

	public boolean esCerradoAIzquierda() {
		return this.extremoIzquierdo.esCerrado();
	}

	public boolean esAbiertoAIzquierda() {
		return this.extremoIzquierdo.esAbierto();
	}

	public boolean esCerradoADerecha() {
		return this.extremoDerecho.esCerrado();
	}

	public boolean esAbiertoADerecha() {
		return this.extremoDerecho.esAbierto();
	}

	public boolean esAbierto() {
		return this.esAbiertoAIzquierda() && this.esAbiertoADerecha();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(extremoDerecho, extremoIzquierdo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rango other = (Rango) obj;
		return Objects.equals(extremoDerecho, other.extremoDerecho)
				&& Objects.equals(extremoIzquierdo, other.extremoIzquierdo);
	}

}
