package edu.unlam.paradigmas.basicas.ej01;

public class ExtremoIzquierdo extends Extremo{

	public ExtremoIzquierdo(double valor, boolean cerrado) {
		super(valor, cerrado);
	}

	public boolean ValorIncluido(double valor) {
		if (this.esCerrado()) {
			return Double.compare(valor, this.valor) >= 0;
		}
		
		return Double.compare(valor, this.valor) > 0;
	}
}