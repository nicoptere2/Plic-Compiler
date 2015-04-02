package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

public class Add extends OperationArithmetique{
	public Add() {
	}
	
	@Override
	public String toString() {
		return this.operandeGauche + "+" + this.operandeDroite;
	}

	@Override
	protected String getInstr() {
		return "#Addition \nadd";
	}
}
