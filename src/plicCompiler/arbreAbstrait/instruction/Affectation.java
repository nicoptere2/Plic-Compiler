package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.exception.ListErreurSem;
import plicCompiler.exception.SemanticsException;
import plicCompiler.tDS.Symbole;
import plicCompiler.tDS.TDS;

public class Affectation extends Instruction{
	
	private Identificateur identificateur;
	
	private Expression expression;
	
	public Affectation(Identificateur identificateur, Expression e, int ligne) {
		super(ligne);
		this.identificateur = identificateur;
		this.expression = e;
	}
	

	@Override
	public String toCode() {
		
		StringBuilder s = new StringBuilder();
		
		s.append("# Affectation de la variable '" + this.identificateur + "' !\n");
		Symbole sym = TDS.getInstance().identifier(identificateur);
		s.append(this.expression.toCode());
		s.append("sw $v0, -" + sym.getDeplacement() + "($s7)\n");
		return s.toString();
	}

	@Override
	public void check() throws SemanticsException {
		this.expression.check();
		this.identificateur.check();

		if(expression.getType() != this.identificateur.getType())
			throw new SemanticsException("Le type de la variable et de l'expression ne correspondent pas", "0");
		
	}
	
	@Override
	public String toString() {
		return this.identificateur + " = " + this.expression + "\n";
	}
}
