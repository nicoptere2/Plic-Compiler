package plicCompiler.arbreAbstrait.expression.constante;

import plicCompiler.arbreAbstrait.expression.Expression;

public class ConstanteLogique extends Constante{

	public ConstanteLogique(String c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void checkType() {
		this.type = Expression.Type.LOGICAL;
	}

}
