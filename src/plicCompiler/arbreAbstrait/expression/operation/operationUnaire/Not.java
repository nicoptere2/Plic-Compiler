package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.exception.SemanticsException;

public class Not extends OperationUnaire {

	public Not(Expression e) {
		super(e);
	}

	@Override
	protected String getInstr() {
		return "#Not \nnot";
	}

	@Override
	public void check() throws SemanticsException{
		this.exp.check();
		if(this.exp.getType() != Expression.Type.LOGICAL)
			throw new SemanticsException();
		
		this.type = Expression.Type.LOGICAL;
	}
}
