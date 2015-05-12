package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.exception.SemanticsException;
import plicCompiler.tDS.Symbole;

public class ExpressionNegative extends OperationUnaire{

	public ExpressionNegative(Expression e) {
		super(e);
	}

	@Override
	public String toString() {
		return "-" + exp.toString();
	}

	@Override
	protected String getInstr() {
		if(this.type == Symbole.Type.ENTIER)
			return "#Oposé \nneg";
		else
			return "#Oposé \nnot";
		
	}
	
	@Override
	public void check() throws SemanticsException{
		this.exp.check();
		if(this.exp.getType() == Symbole.Type.ENTIER)
			this.type = Symbole.Type.ENTIER;
		else if(this.exp.getType() == Symbole.Type.BOOL)
			this.type = Symbole.Type.ENTIER;
		else
			throw new SemanticsException("Type de l'opérateur inattendu");
	}
}
