package plicCompiler.arbreAbstrait.expression;

public class Identificateur extends Expression{
	
	private String identificateur;
	
	public Identificateur(String idf) {
		this.identificateur = idf;
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
