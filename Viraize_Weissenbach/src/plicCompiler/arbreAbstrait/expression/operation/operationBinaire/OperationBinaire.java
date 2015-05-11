package plicCompiler.arbreAbstrait.expression.operation.operationBinaire;

import plicCompiler.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Expression;

public abstract class OperationBinaire extends Expression{
	protected Expression operandeGauche;
	protected Expression operandeDroite;

	public OperationBinaire(Expression e1, Expression e2) {
		this.operandeGauche = e1;
		this.operandeDroite = e2;
	}

	public void setOperandeGauche(Expression operandeGauche) {
		this.operandeGauche = operandeGauche;
	}

	public void setOperandeDroite(Expression operandeDroite) {
		this.operandeDroite = operandeDroite;
	}

	@Override
	public abstract String toString();
	
	protected abstract String getInstr();
	
	public abstract void checkType() throws TypeIncompatibleException;
	
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
		code.append(this.getInstr() + " $v0, $t8, $v0\n");
		code.append("\n\n");
		
		return code.toString();
	}
}
