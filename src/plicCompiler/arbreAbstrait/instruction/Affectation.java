package plicCompiler.arbreAbstrait.instruction;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
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
		
		StringBuilder s = new StringBuilder();
		
		s.append("# Affectation de la variable '" + this.identificateur + "' !\n");
		Symbole sym = TDS.getInstance().identifier(identificateur);
		s.append(this.expression.toCode());
		s.append("sw $v0, -" + sym.getDeplacement() + "($s7)\n");
		return s.toString();
	}

	@Override
	public void check() throws TypeIncompatibleException {
		try{
		expression.check();
		} catch(TypeIncompatibleException e) {
			System.out.println("c'est ici...");
		}
		if(expression.getType() == Expression.Type.LOGICAL)
			throw new TypeIncompatibleException("Affectation impossible du a une erreur de type");
		
	}
	
	@Override
	public String toString() {
		return this.identificateur + " = " + this.expression + "\n";
	}
}
