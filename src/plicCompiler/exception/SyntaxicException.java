package plicCompiler.exception;

@SuppressWarnings("serial")
public class SyntaxicException extends Exception{
	public SyntaxicException(){
		super();
	}
	
	public SyntaxicException(String message){
		super("ERREUR SYNTAXIQUE" + message);
	}
	
	public SyntaxicException(String message, String noLigne){
		super("ERREUR SYNTAXIQUE : " + noLigne + " : " + message);
	}
}
