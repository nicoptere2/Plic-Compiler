package plicCompiler.arbreAbstrait.expression.operation.operationUnaire;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.expression.Expression;

public class Not extends OperationUnaire {

	public Not(Expression e) {
		super(e);
	}

	@Override
	protected String getInstr() {
		return "#Not \nnot";
	}

	@Override
	public void check() throws TypeIncompatibleException{
		this.exp.check();
		if(this.exp.getType() != Expression.Type.LOGICAL)
			throw new TypeIncompatibleException();
		
		this.type = Expression.Type.LOGICAL;
	}
}
