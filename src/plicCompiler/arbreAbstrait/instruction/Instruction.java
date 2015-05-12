package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.exception.SemanticsException;

public abstract class Instruction extends ArbreAbstrait {
	
	public abstract String toCode();

	public abstract void check() throws SemanticsException;
}
