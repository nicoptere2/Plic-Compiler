package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.exception.ListErreurSem;
import plicCompiler.exception.SemanticsException;
import plicCompiler.tDS.TDS;

public class Lire extends Instruction {
	
	private Identificateur variable;
	
	public Lire(Identificateur variable, int ligne) {
		super(ligne);
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
	public void check() throws SemanticsException {
		this.variable.check();
	}
	
	@Override
	public String toString() {
		return "lire(" + variable.toString() + ")\n";
	}

}
