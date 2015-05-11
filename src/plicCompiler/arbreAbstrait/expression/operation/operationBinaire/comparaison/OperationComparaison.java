package plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison;

import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.OperationBinaire;
import plicCompiler.exception.SemantiqueException;
import plicCompiler.tDS.Symbole;

public abstract class OperationComparaison extends OperationBinaire {

	public OperationComparaison(Expression e1, Expression e2) {
		super(e1, e2);
	}

	@Override
	public void check() throws Exception {
		this.operandeGauche.check();
		this.operandeDroite.check();
		
		if((this.operandeGauche.getType() != Symbole.Type.ENTIER) || (this.operandeDroite.getType() != Symbole.Type.ENTIER))
			throw new SemantiqueException("Operation de type Arithmetique attendu, logique trouv�");
		
		this.type = Symbole.Type.BOOL;
	}
	
}
