package plicCompiler.analyseSemantique;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.tDS.TDS;

public class AnalyseurSemantique {
	
	private ArbreAbstrait arbreAbstrait;

	public AnalyseurSemantique(ArbreAbstrait arbreAbstrait) {
		this.arbreAbstrait = arbreAbstrait;
	}

	public void check(){
		try {
			TDS.getInstance().setAnalyseSyntaxique(false);
			TDS.getInstance().check();
			arbreAbstrait.check();
		} catch (TypeIncompatibleException e) {
			System.out.println(arbreAbstrait.toString());
			System.out.println("Erreur : " + e.getMessage());
			System.exit(0);
		}
	}

}
