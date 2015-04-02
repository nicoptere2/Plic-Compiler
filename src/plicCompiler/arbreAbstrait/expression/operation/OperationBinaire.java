package plicCompiler.arbreAbstrait.expression.operation;

import plicCompiler.arbreAbstrait.expression.Expression;

public abstract class OperationBinaire extends Expression{
	protected Expression operandeGauche;
	protected Expression operandeDroite;
	
	public OperationBinaire() {

	}

	public void setOperandeGauche(Expression operandeGauche) {
		this.operandeGauche = operandeGauche;
	}

	public void setOperandeDroite(Expression operandeDroite) {
		this.operandeDroite = operandeDroite;
	}

	@Override
	public abstract String toString();
	
	@Override
	public abstract String toCode();

}
