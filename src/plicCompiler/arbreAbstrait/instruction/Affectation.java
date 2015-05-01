package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.Identificateur;

public class Affectation extends Instruction{
	
	private Identificateur identificateur;
	
	private Expression expression;
	
	public Affectation(Identificateur identificateur, Expression e) {
		this.identificateur = identificateur;
		this.expression = e;
	}
	
	@Override
	public String toString() {
		return this.identificateur + " = " + this.expression + "\n";
	}
}
