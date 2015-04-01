package plicCompiler.arbreAbstrait.expression.operation.logique;

public class LowerThan extends OperationLogique {

	public LowerThan() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + "<" + this.operandeDroite;
	}

}
