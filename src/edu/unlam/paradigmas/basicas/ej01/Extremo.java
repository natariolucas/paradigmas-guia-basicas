package edu.unlam.paradigmas.basicas.ej01;

import java.util.Objects;

public class Extremo {

	@Override
	public int hashCode() {
		return Objects.hash(cerrado, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Extremo other = (Extremo) obj;
		return cerrado == other.cerrado && Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}

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
