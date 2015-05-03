package plicCompiler.tDS;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class LocalDictionnary {
	
	private LocalDictionnary father;
	private Queue<LocalDictionnary> children;
	
	private int idBlock;
	
	private Map<Entre, Symbole> dictionnary;
	
	public LocalDictionnary() {
		this.father = null;
		this.idBlock = 0;
		children = new PriorityQueue<LocalDictionnary>();
		
		this.dictionnary = new HashMap<Entre, Symbole>();
	}
	
	private LocalDictionnary(LocalDictionnary father, int idBlock) {
		this.father = father;
		this.idBlock = idBlock;

		
		children = new PriorityQueue<LocalDictionnary>();
		this.dictionnary = new Hashtable<Entre, Symbole>();
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
		dictionnary.put(e, s);
	}
	
	public void checkAll() {
		
		this.check();
		
		for(LocalDictionnary ld : children){
			ld.checkAll();
		}
	}
	
	/**
	 * Analyse semantique du dictionnaire local
	 * met en place les toutes les valeurs de chaque symboles
	 * verifie les doublons dans la Map
	 */
	public void check() {
		int deplacement = TDS.deplacementInitial;
		for(Entry<Entre, Symbole> m : this.dictionnary.entrySet()){
			m.getValue().setIdBlock(idBlock);
			m.getValue().setDeplacement(deplacement);
			deplacement += m.getValue().getTaille();
		}
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
		for(Entry<Entre, Symbole> m : this.dictionnary.entrySet()){
			s.append("\t" + m.getKey() + "\t\t=>\t" + m.getValue() + "\n");
		}
		
		s.append("\n");
		
		for(LocalDictionnary ld : children){
			s.append(ld.toString());
		}
		
		return s.toString();
	}
}
