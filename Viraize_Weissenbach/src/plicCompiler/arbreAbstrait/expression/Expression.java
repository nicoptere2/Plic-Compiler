package plicCompiler.arbreAbstrait.expression;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;


public class Expression extends ArbreAbstrait {
	
	protected Expression exp;
	
	protected Type type;
	
	protected enum Type {LOGICAL, ARITMETICAL;};
	
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
	public void checkType() throws TypeIncompatibleException{
		exp.checkType();
		this.type = exp.getType();
	}
	
}
