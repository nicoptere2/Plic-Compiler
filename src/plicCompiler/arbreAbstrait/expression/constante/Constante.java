package plicCompiler.arbreAbstrait.expression.constante;

import plicCompiler.arbreAbstrait.expression.Expression;


public abstract class Constante extends Expression {
	
	protected String constante;

	public Constante(String c) {
		this.constante = c;
	}

	@Override
	public String toString() {
		return constante;
	}
	
	@Override
	public String toCode() {
		StringBuffer code = new StringBuffer();
		code.append("#Chargement de " + this.constante + " dans $v0\n");
		code.append("li $v0, " + this.constante + "\n");
		return code.toString();
	}
	
	@Override
	public abstract void check();
}
