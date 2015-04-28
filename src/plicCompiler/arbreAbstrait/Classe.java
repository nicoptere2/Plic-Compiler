package plicCompiler.arbreAbstrait;

import plicCompiler.arbreAbstrait.Instruction.ListeInstruction;
import plicCompiler.arbreAbstrait.Mot.Identificateur;

public class Classe extends ArbreAbstrait {
	
	private Identificateur identificateur;
	
	private ListeInstruction instructions;
	
	public Classe(Identificateur idf, ListeInstruction list) {
		this.identificateur = idf;
		this.instructions = list;
	}
}
