package plicCompiler.arbreAbstrait.Instruction;

import plicCompiler.arbreAbstrait.expression.constante.ConstanteChaine;

public class EcrireConstante extends Ecrire {
	
	private ConstanteChaine chaine;
	
	public EcrireConstante(ConstanteChaine chaine) {
		this.chaine = chaine;
	}
}
