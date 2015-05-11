package plicCompiler.tDS;

import java.util.ArrayList;

import plicCompiler.arbreAbstrait.expression.Identificateur;

public class TDS {
	
	private static TDS instance = null;

	public static int deplacementInitial = 12;
	
	private boolean analyseSyntaxique = true;
	
	private LocalDictionnary currentBlock;
	
	private int idBlock = 0;
	
	public static TDS getInstance() {
		if(TDS.instance == null)
			TDS.instance = new TDS();
		
		return instance;
	}
	
	private TDS() {
		this.currentBlock = new LocalDictionnary();
	}
	
	public void entrerBlock() {
		//System.out.println("boolean : " + analyseSyntaxique);
		if(this.analyseSyntaxique){
			idBlock++;
			currentBlock = currentBlock.newChild(idBlock);
		}
		else {
			//System.out.println("salut" + currentBlock);
			currentBlock = currentBlock.nextChild();
			//System.out.println(currentBlock);
		}
	}
	
	public void sortirBlock() {
		currentBlock = currentBlock.getFather();
	}
	
	public void ajouter(Identificateur e, Symbole s) {
		currentBlock.add(e,s);
	}
	
	public void ajouter(ArrayList<Identificateur> listE, Symbole s) {
		for(Identificateur e: listE)
			currentBlock.add(e, s.clone());
	}
	
	public void setAnalyseSyntaxique(boolean analyseSyntaxique) {
		this.analyseSyntaxique = analyseSyntaxique;
	}
	
	public String toCode() {
		return this.currentBlock.codeEntre();
	}

	@Override
	public String toString() {
		return currentBlock.toString();
	}

	public void check() {
		this.currentBlock.checkAll();
	}

	public Symbole identifier(Identificateur identificateur) {
		return this.currentBlock.identifier(identificateur);
	}

	public LocalDictionnary getCurrentDictionnary() {
		return this.currentBlock;
	}

	public String codeEntre() {
		return this.currentBlock.codeEntre();
	}

	public String codeSortie() {
		return this.currentBlock.codeSortie();
	}

}
