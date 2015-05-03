package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.logique;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
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
	public void check() throws TypeIncompatibleException {
		this.operandeGauche.check();
		this.operandeDroite.check();
		
		if((this.operandeGauche.getType() != Expression.Type.LOGICAL) || (this.operandeDroite.getType() != Expression.Type.LOGICAL))
			throw new TypeIncompatibleException();
		
		this.type = Expression.Type.LOGICAL;
	}

}
