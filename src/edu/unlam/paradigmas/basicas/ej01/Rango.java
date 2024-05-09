package edu.unlam.paradigmas.basicas.ej01;

import java.util.Objects;

public class Rango {
	private static final String SEPARADOR = ",";

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
	
	private Rango(ExtremoIzquierdo izquierdo, ExtremoDerecho derecho) {
		this.extremoIzquierdo = izquierdo;
		this.extremoDerecho = derecho;
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

	public static Rango NewRangoAbarcativo(Rango[] rangos) {
		Rango rangoAbarcativo = NewRangoAbierto(0, 0); // Rango cero

		for (Rango rango : rangos) {
			rangoAbarcativo = rangoAbarcativo.sumar(rango);
		}

		return rangoAbarcativo;

	}

	private static Rango SumarRangos(Rango r1, Rango r2) {
		ExtremoIzquierdo izquierdo = r1.getExtremoIzquierdo().sumar(r2.getExtremoIzquierdo());
		ExtremoDerecho derecho = r1.getExtremoDerecho().sumar(r2.getExtremoDerecho());

		return new Rango(izquierdo,derecho);
	}



	public boolean incluyeValor(double valor) {
		return this.extremoIzquierdo.incluyeValor(valor) && this.extremoDerecho.incluyeValor(valor);
	}

	public boolean incluyeRango(Rango otro) {
		return this.extremoIzquierdo.incluyeExtremo(otro.extremoIzquierdo)
				&& this.extremoDerecho.incluyeExtremo(otro.extremoDerecho);
	}
	
	private boolean intersectaRangoPorIzquierda(Rango otro) {
		return this.extremoIzquierdo.incluyeExtremo(otro.extremoIzquierdo)
				&& this.extremoDerecho.incluyeExtremo(otro.extremoIzquierdo);
	}

	private boolean intersectaRangoPorDerecha(Rango otro) {
		return this.extremoIzquierdo.incluyeExtremo(otro.extremoDerecho)
		&& this.extremoDerecho.incluyeExtremo(otro.extremoDerecho);
	}
	
	public boolean intersectaRango(Rango otro) {
		return (this.intersectaRangoPorIzquierda(otro))
				|| (this.intersectaRangoPorDerecha(otro))
				|| otro.incluyeRango(this);
	}

	public Rango obtenerRangoIntersección(Rango otro) {
		ExtremoIzquierdo mayorIzquierdo = this.extremoIzquierdo;
		if (this.extremoIzquierdo.compareTo(otro.extremoIzquierdo) < 0) {
			mayorIzquierdo = otro.extremoIzquierdo;
		}
		
		ExtremoDerecho menorDerecho = this.extremoDerecho;
		if (this.extremoDerecho.compareTo(otro.extremoDerecho) > 0) {
			menorDerecho = otro.extremoDerecho;
		}
		
		if (Double.compare(mayorIzquierdo.getValor(), menorDerecho.getValor()) > 0) {
			return NewRangoAbierto(0,0);
		}
		
		return new Rango(mayorIzquierdo, menorDerecho);
	}
	
	public double getValorAIzquierda() {
		return this.extremoIzquierdo.getValor();
	}

	public double getValorADerecha() {
		return this.extremoDerecho.getValor();
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

	public Rango sumar(Rango otro) {
		return SumarRangos(this, otro);
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

	@Override
	public String toString() {
		return this.extremoIzquierdo.toString() + SEPARADOR + this.extremoDerecho.toString();
	}

	private ExtremoIzquierdo getExtremoIzquierdo() {
		return extremoIzquierdo;
	}

	private ExtremoDerecho getExtremoDerecho() {
		return extremoDerecho;
	}

}
