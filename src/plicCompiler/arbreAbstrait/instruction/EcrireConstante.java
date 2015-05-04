package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.constante.ConstanteChaine;
import plicCompiler.arbreAbstrait.expression.constante.ListChaine;

public class EcrireConstante extends Ecrire {
	
	private String etiquette;
	
	public EcrireConstante(ConstanteChaine chaine) {
		etiquette = ListChaine.getInstance().push(chaine);
	}
	

	@Override
	public String toCode() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return "ecrire (" + etiquette + ")\n";
	}
}
