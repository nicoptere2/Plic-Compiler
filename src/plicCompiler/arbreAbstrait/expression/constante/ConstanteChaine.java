package plicCompiler.arbreAbstrait.expression.constante;

public class ConstanteChaine extends Constante {

	public ConstanteChaine(String c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void checkType() {
		// TODO Auto-generated method stub
	}
	
	@Override
	public String toString() {
		return "chaine : " + this.constante;
	}

}
