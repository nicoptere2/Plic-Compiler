package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;

public class Div extends OperationArithmetique {

	public Div(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	protected String getInstr() {
		return "#Division \n" + this.operateur;
	}
	
	@Override
	public void check() throws TypeIncompatibleException {
		super.check();
		if((this.operandeGauche.getType() != Expression.Type.ARITMETICAL) || (this.operandeDroite.getType() != Expression.Type.ARITMETICAL))
			throw new TypeIncompatibleException();
	}

	@Override
	protected void setOperateur() {
		this.operateur = "div";
	}
}
