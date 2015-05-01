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
	public String toString() {
		return this.operandeGauche + " " + ((this.operateur==null)? "?" : this.operateur) + " " + this.operandeDroite;
	}

	@Override
	protected abstract String getInstr();
	
	protected abstract void setOperateur();
	
	@Override
	public void checkType() throws TypeIncompatibleException {
		this.operandeGauche.checkType();
		this.operandeDroite.checkType();
		
		if(this.operandeGauche.getType() !=  this.operandeDroite.getType() )
			throw new TypeIncompatibleException("Differents type d'operateur trouv�");
		
		this.setType(this.operandeDroite.getType());
		
		this.setOperateur();
	}
}
