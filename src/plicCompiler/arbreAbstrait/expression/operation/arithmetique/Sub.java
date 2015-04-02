package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

public class Sub extends OperationArithmetique {

	public Sub() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return this.operandeGauche + "-" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Soustraction \nsub";
	}

}
