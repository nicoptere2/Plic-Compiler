package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.arbreAbstrait.expression.Expression;


public abstract class OperationUnaire extends Expression {
	
	protected Expression exp;
	
	public OperationUnaire(Expression e) {
		this.exp = e;
	}
	
	@Override
	public String toCode() {
		StringBuffer code = new StringBuffer();
		
		code.append(exp.toCode());
		code.append("#Chargement Operande dans la pile\n");
		code.append("sw $v0, ($sp)\n");
		code.append("addi $sp, $sp, -4\n\n");
		
		code.append("#Chargement Operande dans $v0\n");
		code.append("addi $sp, $sp, 4\n");
		code.append("lw $v0, ($sp)\n");
		
		code.append("#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)\n");
		code.append(this.getInstr() + " $v0, $v0\n");
		
		return code.toString();
		
	}
	
	protected abstract String getInstr();
}
