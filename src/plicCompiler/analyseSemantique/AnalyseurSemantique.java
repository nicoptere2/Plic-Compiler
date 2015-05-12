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
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("unexpected error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
