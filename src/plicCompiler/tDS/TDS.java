package plicCompiler.tDS;

import java.util.ArrayList;

import plicCompiler.arbreAbstrait.expression.Identificateur;

public class TDS {
	
	private static TDS instance = null;

	public static int deplacementInitial = 16;
	
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
		if(this.analyseSyntaxique){
			idBlock++;
			currentBlock = currentBlock.newChild(idBlock);
		}
		else {
			currentBlock = currentBlock.nextChild();
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

	@Override
	public String toString() {
		return currentBlock.toString();
	}

	public void check() {
		System.out.println("coucou c'est moi");
		this.currentBlock.checkAll();
	}

	public Symbole identifier(Identificateur identificateur) {
		return this.currentBlock.identifier(identificateur);
	}

	public LocalDictionnary getCurrentDictionnary() {
		return this.currentBlock;
	}
}
