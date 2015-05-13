package plicCompiler.exception;

public class ErreurSem {
	
	private String message;
	
	private String ligne;

	public ErreurSem(String message, String ligne) {
		this.message = message;
		this.ligne = ligne;
	}
	
	public String toString() {
		return "ERREUR SYNTAXIQUE : " + ligne + " : " + message;
	}

}
