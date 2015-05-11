package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;
import plicCompiler.tDS.Symbole;

public class Add extends OperationArithmetique{
	public Add(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	protected String getInstr() {
		return "#Addition \n" + this.operateur;
	}

	@Override
	protected void setOperateur() {
		if(this.type == Symbole.Type.ENTIER)
			this.operateur = "add";
		else if(this.type == Symbole.Type.BOOL)
			this.operateur = "or";
	}
}
