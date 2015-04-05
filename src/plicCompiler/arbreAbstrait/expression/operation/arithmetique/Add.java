package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;

public class Add extends OperationArithmetique{
	public Add(Expression e1, Expression e2) {
		super(e1, e2);
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + "+" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Addition \nadd";
	}
}
