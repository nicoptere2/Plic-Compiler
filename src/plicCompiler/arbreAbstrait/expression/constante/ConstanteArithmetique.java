package plicCompiler.arbreAbstrait.expression.constante;

import plicCompiler.tDS.Symbole;

public class ConstanteArithmetique extends Constante{
	public ConstanteArithmetique(String c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void check() {
		this.type = Symbole.Type.ENTIER;
	}
}
