package plicCompiler.arbreAbstrait.expression.operation.logique;

public class GreaterThan extends OperationLogique {

	public GreaterThan() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + ">" + this.operandeDroite;
	}

	@Override
	public String toCode() {
		// TODO Auto-generated method stub
		return null;
	}

}
