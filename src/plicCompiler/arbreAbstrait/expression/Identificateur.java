package plicCompiler.arbreAbstrait.expression;

public class Identificateur extends Expression {
	
	private String identificateur;
	
	public Identificateur(String identificateur) {
		this.identificateur = identificateur;
	}
	
	@Override
	public String toString() {
		return this.identificateur;
	}
}
