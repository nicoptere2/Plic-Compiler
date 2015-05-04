package plicCompiler.arbreAbstrait.expression;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.tDS.Symbole;
import plicCompiler.tDS.TDS;

public class Identificateur extends Expression{
	
	private String identificateur;
	
	private Symbole symbole;
	
	public Identificateur(String idf) {
		this.identificateur = idf;
	}
	
	public String codeTake() {
		StringBuilder s = new StringBuilder();
		
		s.append("# chargement de la variable '" + identificateur + "' dans $v0\n");
		s.append("lw $v0, -"+ symbole.getDeplacement() + "($s7) \n");
		
		return s.toString();
	}
	
	public String codePut() {
		StringBuilder s = new StringBuilder();
		
		s.append("# affectation dans la variable '" + identificateur + "' de $v0\n");
		s.append("sw $v0, -" + symbole.getDeplacement() + "($s7) \n");
		
		return s.toString();
	}
	
	@Override
	public void check() throws TypeIncompatibleException {
		symbole = TDS.getInstance().identifier(this);
		//System.out.println("identificateur : " + s);
		if(symbole.getType() == Symbole.Type.ENTIER)
			this.type = Expression.Type.ARITMETICAL;
		else
			throw new TypeIncompatibleException();
	}
	
	@Override
	public boolean equals(Object e) {
		e = (Identificateur) e;
		return e.toString().equals(identificateur);
	}
	
	@Override
	public int hashCode() {
		return this.toString().hashCode();
	}
	
	@Override
	public String toString() {
		return this.identificateur;
	}

}
