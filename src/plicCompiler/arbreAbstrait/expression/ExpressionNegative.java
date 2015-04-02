package plicCompiler.arbreAbstrait.expression;

import plicCompiler.arbreAbstrait.expression.operation.OperationBinaire;

public class ExpressionNegative extends Expression{
	
	protected Expression exp;
	
	public ExpressionNegative(Expression e) {
		this.exp = e;
	}
	
	@Override
	public String toString() {
		return "-" + exp.toString();
	}
	
	@Override
	public String toCode() {
		StringBuffer code = new StringBuffer();
		
		code.append(exp.toCode());
		code.append("#Chargement Operande gauche dans la pile\n");
		code.append("sw $v0, ($sp)\n");
		code.append("addi $sp, $sp, -4\n\n");

		code.append("#Chargement de " + (-1) + "dans $v0\n");
		code.append("li $v0, " + (-1) + "\n");
		
		code.append("#Chargement Operande droite dans la pile\n");
		code.append("sw $v0, ($sp)\n");
		code.append("addi $sp, $sp, -4\n");
		
		code.append("#Chargement Operande droite dans $v0\n");
		code.append("addi $sp, $sp, 4\n");
		code.append("lw $v0, ($sp)\n");
		
		code.append("#Chargement Operande gauche dans $t8\n");
		code.append("addi $sp, $sp, 4\n");
		code.append("lw $t8, ($sp)\n");
		
		code.append("#Calcule de OperandeGauche @ OperandeDroite (@ => operateur)\n");
		code.append("mul $v0, $t8, $v0\n");
		
		return code.toString();
		
	}
}
