package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;
import plicCompiler.exception.SemanticsException;
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
	public void check() throws SemanticsException {
		super.check();
		if((this.operandeGauche.getType() != Symbole.Type.ENTIER) || (this.operandeDroite.getType() != Symbole.Type.ENTIER))
			throw new SemanticsException();
	}

	@Override
	protected void setOperateur() throws SemanticsException {
		if(this.type == Symbole.Type.ENTIER)
			this.operateur = "div";
		else
			throw new SemanticsException("Type inattendu");
	}
}
