package plicCompiler.arbreAbstrait.expression;

import plicCompiler.arbreAbstrait.ArbreAbstrait;


public class Expression extends ArbreAbstrait {
	
	private Expression exp;
	
	public Expression(){
	}
	
	public Expression(Expression e){
		this.exp = e;
	}
	
	@Override
	public String toString() {
		return exp.toString();
	}
	
}
