package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.exception.SemanticsException;

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
	
	@Override
	public void check() throws SemanticsException{
		this.exp.check();
		if(this.exp.getType() != Expression.Type.ARITMETICAL)
			throw new SemanticsException();
		
		this.type = Expression.Type.ARITMETICAL;
	}
}
