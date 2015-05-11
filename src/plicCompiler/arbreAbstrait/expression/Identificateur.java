package plicCompiler.arbreAbstrait.expression;

import plicCompiler.exception.SemantiqueException;
import plicCompiler.tDS.Symbole;
import plicCompiler.tDS.TDS;

public class Identificateur extends Expression{
	
	private String identificateur;
	
	private Symbole symbole;
	
	public Identificateur(String idf) {
		this.identificateur = idf;
	}
	
	@Override
	public String toCode() {
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
	public void check() throws Exception {
		symbole = TDS.getInstance().identifier(this);
		
		if(symbole != null)
			this.setType(symbole.getType());
		else
			throw new SemantiqueException("Identificateur non déclaré");
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
