package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.exception.TypeIncompatibleException;
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
	
	@Override
	public void checkType() throws TypeIncompatibleException{
		this.exp.checkType();
		if(this.exp.getType() != Expression.Type.ARITMETICAL)
			throw new TypeIncompatibleException();
		
		this.type = Expression.Type.ARITMETICAL;
	}
}
