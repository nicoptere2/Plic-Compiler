package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.exception.SemantiqueException;
import plicCompiler.tDS.Symbole;

public class Div extends OperationArithmetique {

	public Div(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	protected String getInstr() {
		return "#Division \n" + this.operateur;
	}
	
	@Override
	public void check() throws Exception {
		super.check();
		if((this.operandeGauche.getType() != Symbole.Type.ENTIER) || (this.operandeDroite.getType() != Symbole.Type.ENTIER))
			throw new SemantiqueException("");
	}

	@Override
	protected void setOperateur() {
		this.operateur = "div";
	}
}
