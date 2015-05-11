package plicCompiler.exception;

public class SemantiqueException extends Exception {

	public SemantiqueException(String message) {
		super("ERREUR SEMANTIQUE :"+message);
	}

}
