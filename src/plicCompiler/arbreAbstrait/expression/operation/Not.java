package plicCompiler.arbreAbstrait.expression.operation;

import plicCompiler.arbreAbstrait.expression.Expression;

public class Not extends OperationUnaire {

	public Not(Expression e) {
		super(e);
	}

	@Override
	protected String getInstr() {
		return "#Not \nnot";
	}

}
