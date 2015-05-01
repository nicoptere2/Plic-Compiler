package plicCompiler.arbreAbstrait.instruction;

import java.util.ArrayList;

import plicCompiler.tDS.Entre;

public class Declaration extends Instruction{
	
	private ArrayList<Entre> identifiants;

	public Declaration(ArrayList<Entre> idfs) {
		identifiants = idfs;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Declaration : ");
		for(Entre e : identifiants)
			s.append(e+", ");
		
		s.append("\n");
		return s.toString();
	}

}
