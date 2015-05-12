package plicCompiler.analyseSemantique;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.exception.SemanticsException;
import plicCompiler.tDS.TDS;

public class AnalyseurSemantique {
	
	private ArbreAbstrait arbreAbstrait;

	public AnalyseurSemantique(ArbreAbstrait arbreAbstrait) {
		this.arbreAbstrait = arbreAbstrait;
	}

	public void check(){
		
		TDS.getInstance().setAnalyseSyntaxique(false);
		TDS.getInstance().check();
		
		
		try {
			arbreAbstrait.check();
		} catch (SemanticsException e){
			System.out.println("Type Incompatible...");
			System.out.println("Erreur : " + e.getMessage());
			System.out.println(arbreAbstrait.toString());
			System.exit(0);
		}catch (Exception e) {
			System.out.println("Erreur de type: " + e.getMessage());
			System.out.println(arbreAbstrait.toString());
			System.exit(0);
		}
	}

}
