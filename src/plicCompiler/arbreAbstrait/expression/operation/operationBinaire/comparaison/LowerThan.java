package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;

public class LowerThan extends OperationComparaison {

	
	public LowerThan(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public String toString() {
		return this.operandeGauche + "<" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return new String("#LowerThan \nslt");
	}
}
