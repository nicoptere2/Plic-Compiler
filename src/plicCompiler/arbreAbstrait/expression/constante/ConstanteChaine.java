package plicCompiler.arbreAbstrait.expression.constante;

public class ConstanteChaine extends Constante{

	public ConstanteChaine(String c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void check() {
		this.constante = this.constante.replace("\"\"", "\\\"");
	}
	
	@Override
	public String toCode() {		
		return "\t.asciiz " + super.toString() ;
	}
	
	@Override
	public String toString() {
		return "chaine : " + this.constante;
	}

}
