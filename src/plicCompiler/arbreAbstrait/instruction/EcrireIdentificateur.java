package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Identificateur;


public class EcrireIdentificateur extends Ecrire{
	
	private Identificateur identificateur;

	public EcrireIdentificateur(Identificateur expression) {
		this.identificateur = expression;
	}
	

	@Override
	public String toCode() {
		StringBuilder s = new StringBuilder();
		
		s.append("#Ecriture de la valeur de la variabel '" + identificateur + "' \n");
		s.append(identificateur.toCode());
		s.append("move $a0, $v0\n");
		s.append("li $v0 , 1\n");
		s.append("syscall\n");
		
		return s.toString();
	}

	@Override
	public void check() throws TypeIncompatibleException {
		this.identificateur.check();
	}
	
	@Override
	public String toString() {
		return "ecrire (" + identificateur.toString() + ")\n";
	}

}
