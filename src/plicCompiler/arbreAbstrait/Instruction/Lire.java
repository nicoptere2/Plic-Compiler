package plicCompiler.arbreAbstrait.Instruction;

import plicCompiler.arbreAbstrait.Identificateur;

public class Lire extends Instruction {
	
	private Identificateur variable;
	
	public Lire(Identificateur variable) {
		this.variable = variable;
	}
}
