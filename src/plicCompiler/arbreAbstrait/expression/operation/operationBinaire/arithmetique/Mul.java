package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;

public class Mul extends OperationArithmetique {

	public Mul(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	protected String getInstr() {
		return "#Multiplication \nmul";
	}

	@Override
	protected void setOperateur() {
		if(this.type == Expression.Type.ARITMETICAL)
			this.operateur = "mul";
		else
			this.operateur = "and";
	}

}
