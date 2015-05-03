package plicCompiler.tDS;

import java.util.ArrayList;

public class TDS {
	
	private static TDS instance = null;

	public static int deplacementInitial = 16;
	
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
		idBlock++;
		
		currentBlock = currentBlock.newChild(idBlock);
	}
	
	public void sortirBlock() {
		currentBlock = currentBlock.getFather();
	}
	
	public void ajouter(Entre e, Symbole s) {
		currentBlock.add(e,s);
	}
	
	public void ajouter(ArrayList<Entre> listE, Symbole s) {
		for(Entre e: listE)
			currentBlock.add(e, s.clone());
	}
	
	@Override
	public String toString() {
		return currentBlock.toString();
	}

	public void check() {
		System.out.println("coucou c'est moi");
		this.currentBlock.checkAll();
	}
}
