package edu.unlam.paradigmas.basicas.ej01;

public class Extremo {

	protected double valor;
	protected boolean cerrado;

	public Extremo(double valor, boolean cerrado) {
		this.cerrado = cerrado;
		this.valor = valor;
	}

	public boolean esCerrado() {
		return this.cerrado;
	}

	public boolean esAbierto() {
		return !this.esCerrado();
	}

	public Double getValor() {
		return this.valor;
	}
	
	protected boolean mismaCondicionDeInclusion(Extremo otro) {
		return this.esCerrado() && otro.esCerrado() || this.esAbierto() && otro.esAbierto();
	}

	protected int compararValor(Extremo o) {
		return Double.compare(this.getValor(), o.getValor());
	}

}
