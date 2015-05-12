package plicCompiler.arbreAbstrait.expression;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.exception.SemanticsException;
import plicCompiler.tDS.Symbole.Type;


public class Expression extends ArbreAbstrait {
	
	protected Expression exp;
	
	protected Type type;
	
	public Expression(){
	}
	
	public Expression(Expression e){
		this.exp = e;
	}
	
	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return exp.toString();
	}

	@Override
	public String toCode() {
		return exp.toCode();
	}
	
	@Override
	public void check() throws SemanticsException{
		exp.check();
		this.type = exp.getType();
	}
	
}
