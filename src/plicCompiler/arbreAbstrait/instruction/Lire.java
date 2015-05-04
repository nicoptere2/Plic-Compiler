package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.tDS.TDS;

public class Lire extends Instruction {
	
	private Identificateur variable;
	
	public Lire(Identificateur variable) {
		this.variable = variable;
	}
	

	@Override
	public String toCode() {
		StringBuilder s = new StringBuilder();
		
		s.append("#Lecture de '" + this.variable + "' \n");
		s.append("li $v0, 5\n");
		s.append("syscall\n");
		
		s.append(variable.codePut());
		
		return s.toString();		
	}

	@Override
	public void check() throws TypeIncompatibleException {
		this.variable.check();
	}
	
	@Override
	public String toString() {
		return "lire(" + variable.toString() + ")\n";
	}

}
