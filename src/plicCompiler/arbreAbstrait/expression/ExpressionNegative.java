package plicCompiler.arbreAbstrait.expression;

public class ExpressionNegative extends Expression{
	
	protected Expression exp;
	
	public ExpressionNegative(Expression e) {
		exp = e;
	}
	
	@Override
	public String toString() {
		return "-" + exp.toString();
	}
}
