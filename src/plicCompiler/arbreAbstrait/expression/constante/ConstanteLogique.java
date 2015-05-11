package plicCompiler.arbreAbstrait.expression.constante;

import plicCompiler.tDS.Symbole;

public class ConstanteLogique extends Constante{

	public ConstanteLogique(String c) {
		super(c);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void check() {
		this.type = Symbole.Type.BOOL;
	}

}
