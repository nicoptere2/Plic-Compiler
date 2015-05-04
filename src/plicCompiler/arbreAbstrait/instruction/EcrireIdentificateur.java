package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Identificateur;


public class EcrireIdentificateur extends Ecrire{
	
	private Identificateur identificateur;

	public EcrireIdentificateur(Identificateur expression) {
		this.identificateur = expression;
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
		return "ecrire (" + identificateur.toString() + ")\n";
	}

}
