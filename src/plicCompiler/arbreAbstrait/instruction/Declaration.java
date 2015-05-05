package plicCompiler.arbreAbstrait.instruction;

import java.util.ArrayList;

import plicCompiler.arbreAbstrait.expression.Identificateur;

public class Declaration extends Instruction{
	
	private ArrayList<Identificateur> identifiants;

	public Declaration(ArrayList<Identificateur> idfs) {
		identifiants = idfs;
	}
	

	@Override
	public String toCode() {
		return "# Declaration de variables \n";
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("Declaration : ");
		for(Identificateur e : identifiants)
			s.append(e+", ");
		
		s.append("\n");
		return s.toString();
	}

}
