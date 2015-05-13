package plicCompiler.arbreAbstrait;

import plicCompiler.exception.SemanticsException;

public class ArbreAbstrait {
	
	public ArbreAbstrait() {
		//TODO ecrire le constructeur ici
	}

	public String toCode(){
		return "\n";
	}

	public void check() throws SemanticsException{
	}
	
	@Override
	public String toString() {
		return "arbre";
	}
	
	
	
}
