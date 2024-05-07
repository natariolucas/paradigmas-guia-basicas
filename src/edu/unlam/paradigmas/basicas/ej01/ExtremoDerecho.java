package edu.unlam.paradigmas.basicas.ej01;

public class ExtremoDerecho extends Extremo implements Comparable<ExtremoDerecho> {

	public ExtremoDerecho(double valor, boolean cerrado) {
		super(valor, cerrado);
	}

	public boolean incluyeValor(double valor) {
		if (this.esCerrado()) {
			return Double.compare(valor, this.valor) <= 0;
		}

		return Double.compare(valor, this.valor) < 0;
	}

	@Override
	public int compareTo(ExtremoDerecho otro) {
		int diferenciaDeValor = super.compararValor(otro);
		if (diferenciaDeValor == 0) {

			if (super.mismaCondicionDeInclusion(otro)) {
				return 0;
			}

			if (super.esCerrado()) {
				return 1;
			}

			return -1;

		}

		return diferenciaDeValor;
	}
	
	public boolean incluyeExtremo(ExtremoDerecho otro) {
		return this.compareTo(otro) >= 0;
	}

	public boolean incluyeExtremo(ExtremoIzquierdo izquierdo) {
		int diferenciaDeValor = super.compararValor(izquierdo);
		return ( diferenciaDeValor == 0 && this.esCerrado() && izquierdo.esCerrado() ) || diferenciaDeValor > 0;
	}
	
	@Override
	public String toString() {
		String inclusion = ")";
		if (this.esCerrado()) {
			inclusion = "]";
		}
		
		return super.toString() + inclusion;
	}
}
