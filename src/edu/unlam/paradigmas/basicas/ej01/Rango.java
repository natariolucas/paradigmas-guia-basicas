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
		Rango rangoAbarcativo = NewRangoAbierto(0,0); // Rango cero
		
		for(Rango rango : rangos) {
			rangoAbarcativo = SumarRangos(rangoAbarcativo, rango);
		}
		
		return rangoAbarcativo;
		
	}
	
	
	private static Rango SumarRangos(Rango r1, Rango r2) {
		Rango suma = SumarAIzquierda(r1, r2);
		suma = SumarADerecha(suma,r2);
		
		return suma;
	}
	
	/**
	 * A derecha queda el extremo de r1
	 * A izquierda, el rango resutante no será menor a r1
	 * */
	private static Rango SumarAIzquierda(Rango r1, Rango r2) { // A derecha queda el etremo de r1
		ExtremoIzquierdo izquierdoMenor = r2.getExtremoIzquierdo();
		
		if (r1.getExtremoIzquierdo().compareTo(r2.getExtremoIzquierdo()) < 0 ) {
			izquierdoMenor = r1.getExtremoIzquierdo();
		}
		
		return new Rango(
				izquierdoMenor.esCerrado(),
				izquierdoMenor.getValor(),
				r1.esCerradoADerecha(),
				r1.getValorADerecha()
				);
		
	}
	
	private static Rango SumarADerecha(Rango r1, Rango r2) { // A derecha queda el etremo de r1
		ExtremoDerecho derechoMayor = r2.getExtremoDerecho();
		
		if (r1.getExtremoDerecho().compareTo(r2.getExtremoDerecho()) > 0 ) {
			derechoMayor = r1.getExtremoDerecho();
		}
		
		return new Rango(
				r1.esCerradoAIzquierda(),
				r1.getValorAIzquierda(),
				derechoMayor.esCerrado(),
				derechoMayor.getValor()
				);
		
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
