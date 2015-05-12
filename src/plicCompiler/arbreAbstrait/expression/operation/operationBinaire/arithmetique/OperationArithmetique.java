package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;
import plicCompiler.exception.SemanticsException;

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
	public void check() throws SemanticsException {
		this.operandeGauche.check();
		this.operandeDroite.check();
		
		if(this.operandeGauche.getType() !=  this.operandeDroite.getType() )
			throw new SemanticsException("Differents type d'operateur trouv�");
		
		this.setType(this.operandeDroite.getType());
		
		this.setOperateur();
	}
}
