package plicCompiler.arbreAbstrait.Instruction;

import plicCompiler.arbreAbstrait.Mot.Identificateur;

public class Lire extends Instruction {
	
	private Identificateur variable;
	
	public Lire(Identificateur variable) {
		this.variable = variable;
	}
}
