package plicCompiler.arbreAbstrait.expression.operation.logique;

public class Different extends OperationLogique {

	public Different() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + "!=" + this.operandeDroite;
	}

	@Override
	public String toCode() {
		// TODO Auto-generated method stub
		return null;
	}
}
