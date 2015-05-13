package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.exception.SemanticsException;

public abstract class Instruction extends ArbreAbstrait {
	
	protected int ligne;
	
	public Instruction(int ligne) {
		this.ligne = ligne;
	}
	
	public int getLigne() {
		return ligne;
	}
	
	public abstract String toCode();

	public abstract void check() throws SemanticsException;
}
