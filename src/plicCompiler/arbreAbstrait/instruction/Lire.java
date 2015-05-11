package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.exception.SemantiqueException;
import plicCompiler.tDS.Symbole;
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
	public void check() throws Exception {
		this.variable.check();
		
		Symbole sym = TDS.getInstance().identifier(this.variable);
		if(sym == null)
			throw new SemantiqueException("Variable non déclaré");
	}
	
	@Override
	public String toString() {
		return "lire(" + variable.toString() + ")\n";
	}

}
