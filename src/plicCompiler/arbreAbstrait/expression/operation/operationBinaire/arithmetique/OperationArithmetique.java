package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;

public abstract class OperationArithmetique extends OperationBinaire{
	
	protected String operateur;
	
	public OperationArithmetique(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public abstract String toString();

	@Override
	protected abstract String getInstr();
	
	protected abstract void setOperateur();
	
	@Override
	public void checkType() throws TypeIncompatibleException {
		this.operandeGauche.checkType();
		this.operandeDroite.checkType();
		
		if(this.operandeGauche.getType() !=  this.operandeDroite.getType() )
			throw new TypeIncompatibleException("Differents type d'operateur trouvé");
		
		this.setOperateur();
	}
}
