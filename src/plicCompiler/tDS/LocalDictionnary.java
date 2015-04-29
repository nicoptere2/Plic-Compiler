package plicCompiler.tDS;

import java.util.Map;

public class LocalDictionnary {
	
	private LocalDictionnary father;
	
	private int idBlock;
	
	private Map<Entre, Symbole> dictionnary;
	
	public LocalDictionnary() {
		this.father = null;
		this.idBlock = 0;
	}
	
	private LocalDictionnary(LocalDictionnary father, int idBlock) {
		this.father = father;
		this.idBlock = idBlock;
	}

	public LocalDictionnary newChild(int idBlock) {
		return new LocalDictionnary(this, idBlock);
	}

	public LocalDictionnary getFather() {
		return this.father;
	}

	public void add(Entre e, Symbole s) {
		dictionnary.put(e, s);
	}
}
