package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Identificateur;

public class Lire extends Instruction {
	
	private Identificateur variable;
	
	public Lire(Identificateur variable) {
		this.variable = variable;
	}
	

	@Override
	public String toCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "lire(" + variable.toString() + ")\n";
	}

}
