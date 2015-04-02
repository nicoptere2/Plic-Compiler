package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

public class Div extends OperationArithmetique {

	public Div() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.operandeGauche + "/" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Division \ndiv";
	}
}
