package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;

public class Sub extends OperationArithmetique {

	public Sub(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	protected String getInstr() {
		return "#Soustraction \n" + this.operateur;
	}

	@Override
	protected void setOperateur() {
		if(this.type == Expression.Type.ARITMETICAL)
			this.operateur = "sub";
		else
			this.operateur = "xor";
	}

}
