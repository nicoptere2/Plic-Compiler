package plicCompiler.arbreAbstrait.expression.operation;

import plicCompiler.arbreAbstrait.expression.Expression;

public class ExpressionNegative extends OperationUnaire{

	public ExpressionNegative(Expression e) {
		super(e);
	}

	@Override
	public String toString() {
		return "-" + exp.toString();
	}

	@Override
	protected String getInstr() {
		return "#Oposé \nneg";
	}
}
