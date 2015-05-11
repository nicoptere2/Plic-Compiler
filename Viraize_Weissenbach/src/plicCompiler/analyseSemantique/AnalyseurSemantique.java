package plicCompiler.analyseSemantique;

import plicCompiler.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;

public class AnalyseurSemantique {
	
	private ArbreAbstrait arbreAbstrait;

	public AnalyseurSemantique(ArbreAbstrait arbreAbstrait) {
		this.arbreAbstrait = arbreAbstrait;
	}

	public void check(){
		try {
			arbreAbstrait.checkType();
		} catch (TypeIncompatibleException e) {
			System.out.println(arbreAbstrait.toString());
			System.out.println("Erreur : " + e.getMessage());
			System.exit(0);
		}
	}

}
