package edu.unlam.paradigmas.basicas.ej01;

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
	
	public boolean ValorIncluido(double valor ) {
		return this.extremoIzquierdo.ValorIncluido(valor) && this.extremoDerecho.ValorIncluido(valor);
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

}
