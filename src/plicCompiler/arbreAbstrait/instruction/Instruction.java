package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;

public abstract class Instruction extends ArbreAbstrait {
	
	public abstract String toCode();

	public abstract void check() throws TypeIncompatibleException;
}
