package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

public class Mul extends OperationArithmetique {

	public Mul() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + "*" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Multiplication \nmul";
	}

}
