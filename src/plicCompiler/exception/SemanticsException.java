package plicCompiler.exception;

@SuppressWarnings("serial")
public class SemanticsException extends Exception {
	
	public SemanticsException(){
		super();
	}
	
	public SemanticsException(String message){
		super("ERREUR SEMANTIQUE" + message);
	}
	
	public SemanticsException(String message, int noLigne){
		super("ERREUR SEMANTIQUE" + noLigne + message);
	}
}
