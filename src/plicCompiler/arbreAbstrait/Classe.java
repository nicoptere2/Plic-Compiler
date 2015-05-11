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
	public void check() throws Exception {
		TDS.getInstance().entrerBlock();
		instructions.check();
		TDS.getInstance().sortirBlock();
	}
	
	@Override
	public String toCode() {
		StringBuilder s = new StringBuilder();
		s.append(TDS.getInstance().toCode());
		
		s.append("#on entre dans le block :" + this.identificateur + "\n");
		TDS.getInstance().entrerBlock();
		
		s.append(TDS.getInstance().codeEntre());
		s.append(instructions.toCode());
		
		s.append(TDS.getInstance().codeSortie());
		
		TDS.getInstance().sortirBlock();
		
		return s.toString();
	}
	
	@Override
	public String toString() {
		return "Classe : " + this.identificateur + "\n" + this.instructions; 
	}
}
