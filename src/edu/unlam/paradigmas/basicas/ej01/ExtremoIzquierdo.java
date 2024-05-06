package edu.unlam.paradigmas.basicas.ej01;

public class ExtremoIzquierdo extends Extremo implements Comparable<ExtremoIzquierdo> {

	public ExtremoIzquierdo(double valor, boolean cerrado) {
		super(valor, cerrado);
	}

	public boolean incluyeValor(double valor) {
		if (this.esCerrado()) {
			return Double.compare(valor, this.valor) >= 0;
		}

		return Double.compare(valor, this.valor) > 0;
	}

	@Override
	public int compareTo(ExtremoIzquierdo otro) {
		int diferenciaDeValor = super.compararValor(otro);
		if (diferenciaDeValor == 0) {

			if (super.mismaCondicionDeInclusion(otro)) {
				return 0;
			}

			if (super.esCerrado()) {
				return -1;
			}

			return 1;

		}

		return diferenciaDeValor;
	}
	
	/**
	 * Si son iguales se considera que no lo incluye
	 * */
	public boolean incluyeExtremo(ExtremoIzquierdo otro) {
		return this.compareTo(otro) < 0;
	}

}
