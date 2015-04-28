package plicCompiler.arbreAbstrait.Instruction;

import plicCompiler.arbreAbstrait.Mot.Identificateur;
import plicCompiler.arbreAbstrait.expression.Expression;

public class Affectation extends Instruction{
	
	private Identificateur identificateur;
	
	private Expression expression;
	
	public Affectation(Identificateur identificateur, Expression expression) {
		this.identificateur = identificateur;
		this.expression = expression;
	}
}
