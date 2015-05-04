package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.tDS.Symbole;
import plicCompiler.tDS.TDS;

public class Affectation extends Instruction{
	
	private Identificateur identificateur;
	
	private Expression expression;
	
	public Affectation(Identificateur identificateur, Expression e) {
		this.identificateur = identificateur;
		this.expression = e;
	}
	

	@Override
	public String toCode() {
		
		System.out.println("coucou c'est nous => " + TDS.getInstance().getCurrentDictionnary());
		
		
		StringBuilder s = new StringBuilder();
		
		s.append("# Affectation de la variable!\n");
		Symbole sym = TDS.getInstance().identifier(identificateur);
		s.append(this.expression.toCode());
		s.append("sw $v0, -" + sym.getDeplacement() + "($sp)\n");
		return s.toString();
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String toString() {
		return this.identificateur + " = " + this.expression + "\n";
	}
}
