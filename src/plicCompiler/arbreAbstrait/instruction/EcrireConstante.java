package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.constante.ConstanteChaine;
import plicCompiler.arbreAbstrait.expression.constante.ListChaine;

public class EcrireConstante extends Ecrire {
	
	private String etiquette;
	
	public EcrireConstante(ConstanteChaine chaine, int ligne) {
		super(ligne);
		etiquette = ListChaine.getInstance().push(chaine);
	}
	

	@Override
	public String toCode() {
		StringBuilder s = new StringBuilder();
		
		s.append("# Ecriture de la chaine de caractere'" + etiquette + "' \n");
		s.append("la $a0, " + etiquette + "\n");
		s.append("li $v0 , 4\n");
		s.append("syscall\n");
		
		return s.toString();
	}

	@Override
	public void check() {
		ListChaine.getInstance().check();
	}
	
	@Override
	public String toString() {
		return "ecrire (" + etiquette + ")\n";
	}
}
