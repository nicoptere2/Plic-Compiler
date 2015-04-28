package plicCompiler.arbreAbstrait.Instruction;

import plicCompiler.arbreAbstrait.expression.Expression;

public class EcrireExpression extends Ecrire{
	
	private Expression expression;

	public EcrireExpression(Expression expression) {
		this.expression = expression;
	}

}
