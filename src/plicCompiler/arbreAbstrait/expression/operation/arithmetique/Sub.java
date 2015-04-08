package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.OperationBinaire;

public class Sub extends OperationBinaire {

	public Sub(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public String toString() {
		return this.operandeGauche + "-" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Soustraction \nsub";
	}

}
