package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.tDS.Symbole;

public class ExpressionNegative extends OperationUnaire{
	
	private String operation;

	public ExpressionNegative(Expression e) {
		super(e);
	}

	@Override
	public String toString() {
		return "-" + exp.toString();
	}

	@Override
	protected String getInstr() {
		return operation;
	}
	
	@Override
	public void check() throws Exception{
		this.exp.check();
		if(this.exp.getType() == Symbole.Type.ENTIER)
			this.operation = "#Opposé \nneg";
		else if(this.exp.getType() == Symbole.Type.BOOL)
			this.operation = "#Negation \nnot";
		
		this.type = this.exp.getType();
	}
}
