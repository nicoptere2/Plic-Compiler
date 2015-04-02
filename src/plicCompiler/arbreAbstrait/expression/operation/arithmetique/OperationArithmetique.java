package plicCompiler.arbreAbstrait.expression.operation.arithmetique;

import plicCompiler.arbreAbstrait.expression.operation.OperationBinaire;

public abstract class OperationArithmetique extends OperationBinaire{
	public OperationArithmetique() {
	}
	
	public String toCode() {
		StringBuilder code = new StringBuilder();
		
		
		code.append("#Operation arithmetique!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n");
		code.append(this.operandeGauche.toCode());
		code.append("#Chargement Operande gauche dans la pile\n");
		code.append("sw $v0, ($sp)\n");
		code.append("addi $sp, $sp, -4\n\n");

		code.append(this.operandeDroite.toCode());
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
		code.append(this.getInstr() + " $v0, $v0, $t8\n");
		code.append("\n\n");
		
		return code.toString();
	}

	protected abstract String getInstr();
}
