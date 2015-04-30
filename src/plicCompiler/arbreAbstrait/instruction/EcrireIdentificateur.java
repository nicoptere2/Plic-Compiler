package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Identificateur;


public class EcrireIdentificateur extends Ecrire{
	
	private Identificateur identificateur;

	public EcrireIdentificateur(Identificateur expression) {
		this.identificateur = expression;
	}
	
	@Override
	public String toString() {
		return "ecrire (" + identificateur.toString() + ")\n";
	}

}
