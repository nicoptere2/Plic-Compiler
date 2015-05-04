package plicCompiler.arbreAbstrait;


import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.arbreAbstrait.instruction.ListeInstruction;
import plicCompiler.tDS.TDS;

public class Classe extends ArbreAbstrait {
	
	private Identificateur identificateur;
	
	private ListeInstruction instructions;
	
	public Classe(Identificateur idf, ListeInstruction list) {
		this.identificateur = idf;
		this.instructions = list;
	}
	
	@Override
	public String toCode() {
		TDS.getInstance().entrerBlock();
		String s =  instructions.toCode();
		TDS.getInstance().sortirBlock();
		return s;
	}
	
	@Override
	public String toString() {
		return "Classe : " + this.identificateur + "\n" + this.instructions; 
	}
}
