package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;
import plicCompiler.exception.SemanticsException;

public abstract class OperationComparaison extends OperationBinaire {

	public OperationComparaison(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public void check() throws SemanticsException {
		this.operandeGauche.check();
		this.operandeDroite.check();
		
		if((this.operandeGauche.getType() != Expression.Type.ARITMETICAL) || (this.operandeDroite.getType() != Expression.Type.ARITMETICAL))
			throw new SemanticsException("Operation de type Arithmetique attendu, logique trouv�");
		
		this.type = Expression.Type.LOGICAL;
	}
	
}
