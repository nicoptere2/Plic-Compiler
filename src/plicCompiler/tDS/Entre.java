package plicCompiler.tDS;

public class Entre {
	
	private String identificateur;
	
	public Entre(String idf) {
		this.identificateur = idf;
	}
	
	@Override
	public boolean equals(Object e) {
		e = (Entre) e;
		return e.toString() == this.toString();
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
