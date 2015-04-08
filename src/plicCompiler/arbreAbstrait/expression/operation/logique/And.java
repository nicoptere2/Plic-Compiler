package plicCompiler.arbreAbstrait.expression.operation.logique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.OperationBinaire;



public class And extends OperationBinaire {

	public And(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(this.operandeGauche.toString());
		str.append(" AND ");
		str.append(this.operandeDroite.toString());
		return str.toString();
	}

	@Override
	protected String getInstr() {
		return "#AND \nand";
	}

}
