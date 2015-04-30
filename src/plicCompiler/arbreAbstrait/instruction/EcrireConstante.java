package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.constante.ConstanteChaine;

public class EcrireConstante extends Ecrire {
	
	private ConstanteChaine chaine;
	
	public EcrireConstante(ConstanteChaine chaine) {
		this.chaine = chaine;
	}
	
	@Override
	public String toString() {
		return "ecrire (" + chaine.toString() + ")\n";
	}
}
