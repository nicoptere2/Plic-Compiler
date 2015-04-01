package plicCompiler.arbreAbstrait.expression;

public class Constante extends Expression {
	
	protected String constante;

	public Constante(String c) {
		this.constante = c;
	}

	@Override
	public String toString() {
		return constante;
	}
	
}
