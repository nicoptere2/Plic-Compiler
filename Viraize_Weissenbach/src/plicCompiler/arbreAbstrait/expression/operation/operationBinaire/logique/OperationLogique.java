package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.logique;

import plicCompiler.exception.SemanticsException;
import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;


public abstract class OperationLogique extends OperationBinaire {

	public OperationLogique(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public  abstract String toString();

	@Override
	protected abstract String getInstr();
	
	@Override
	public void checkType() throws TypeIncompatibleException {
		this.operandeGauche.checkType();
		this.operandeDroite.checkType();
		
		if((this.operandeGauche.getType() != Expression.Type.LOGICAL) || (this.operandeDroite.getType() != Expression.Type.LOGICAL))
			throw new TypeIncompatibleException();
		
		this.type = Expression.Type.LOGICAL;
	}

}
