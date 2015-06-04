package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.exception.ListErreurSem;
import plicCompiler.exception.SemanticsException;


public class EcrireIdentificateur extends Ecrire{
	
	private Expression expression;

	public EcrireIdentificateur(Expression expression, int ligne) {
		super(ligne);
		this.expression = expression;
	}
	

	@Override
	public String toCode() {
		StringBuilder s = new StringBuilder();
		
		s.append("#Ecriture de la valeur de la variabel '" + expression + "' \n");
		s.append(expression.toCode());
		s.append("move $a0, $v0\n");
		s.append("li $v0 , 1\n");
		s.append("syscall\n");
		
		return s.toString();
	}

	@Override
	public void check() throws SemanticsException {
		this.expression.check();
	}
	
	@Override
	public String toString() {
		return "ecrire (" + expression.toString() + ")\n";
	}

}
