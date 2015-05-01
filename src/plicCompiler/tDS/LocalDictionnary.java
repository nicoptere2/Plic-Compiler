package plicCompiler.tDS;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LocalDictionnary {
	
	private LocalDictionnary father;
	private Queue<LocalDictionnary> children;
	
	private int idBlock;
	private int deplacement;
	
	private Map<Entre, Symbole> dictionnary;
	
	public LocalDictionnary() {
		this.father = null;
		this.idBlock = 0;
		this.deplacement = 0;
		children = new PriorityQueue<LocalDictionnary>();
		
		this.dictionnary = new HashMap<Entre, Symbole>();
	}
	
	private LocalDictionnary(LocalDictionnary father, int idBlock) {
		this.father = father;
		this.idBlock = idBlock;
		this.deplacement = 0;
		
		children = new PriorityQueue<LocalDictionnary>();
		this.dictionnary = new HashMap<Entre, Symbole>();
	}

	public LocalDictionnary newChild(int idBlock) {
		LocalDictionnary tmp = new LocalDictionnary(this, idBlock);
		this.children.add(tmp);
		
		return tmp;
	}

	public LocalDictionnary getFather() {
		return this.father;
	}

	public void add(Entre e, Symbole s) {
		s.setDeplacement(this.deplacement);
		System.out.println("deplacement : " + s.getDeplacement());
		this.deplacement += s.getTaille();
		dictionnary.put(e, s);
	}
	
	public Symbole identifier(Entre e) {
		
		if(this.dictionnary.containsKey(e))
			return this.dictionnary.get(e);
		
		Symbole s = this.father.identifier(e);
		
		if(s != null)
			return s;
		else {
			// TODO throw runtime error
		}
		
		
		if(this.father == null){
			// TODO throw runtime error
		}
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("idBlock = " + idBlock + "\n");
		s.append("Dictionnaire : \n" + this.dictionnary + "\n");
		
		for(LocalDictionnary ld : children)
			s.append(ld.toString());
		
		return s.toString();
	}
}
