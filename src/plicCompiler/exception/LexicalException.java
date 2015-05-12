package plicCompiler.exception;

@SuppressWarnings("serial")
public class LexicalException extends Exception{
	
	public LexicalException(){
		super();
	}
	
	public LexicalException(String message){
		super("ERREUR SEMANTIQUE" + message);
	}
	
	public LexicalException(String message, int noLigne){
		super("ERREUR SEMANTIQUE" + noLigne + message);
	}
}
