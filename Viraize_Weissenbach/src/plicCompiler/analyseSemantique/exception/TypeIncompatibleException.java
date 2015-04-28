package plicCompiler.analyseSemantique.exception;

@SuppressWarnings("serial")
public class TypeIncompatibleException extends Exception {
	
	public TypeIncompatibleException(){
		super();
	}
	
	public TypeIncompatibleException(String message){
		super(message);
	}
}
