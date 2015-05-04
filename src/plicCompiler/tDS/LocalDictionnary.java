package plicCompiler.tDS;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

import plicCompiler.arbreAbstrait.expression.Identificateur;

public class LocalDictionnary {
	
	private LocalDictionnary father;
	private Vector<LocalDictionnary> children;
	private int currentChild = 0;
	
	private int idBlock;
	
	private Map<Identificateur, Symbole> dictionnary;
	
	public LocalDictionnary() {
		this.father = null;
		this.idBlock = 0;
		children = new Vector<LocalDictionnary>();
		
		this.dictionnary = new HashMap<Identificateur, Symbole>();
	}
	
	private LocalDictionnary(LocalDictionnary father, int idBlock) {
		this.father = father;
		this.idBlock = idBlock;

		
		children = new Vector<LocalDictionnary>();
		this.dictionnary = new Hashtable<Identificateur, Symbole>();
	}

	public LocalDictionnary newChild(int idBlock) {
		LocalDictionnary tmp = new LocalDictionnary(this, idBlock);
		this.children.add(tmp);
		
		return tmp;
	}
	
	public LocalDictionnary nextChild() {
		return this.children.get(currentChild++);
	}

	public LocalDictionnary getFather() {
		return this.father;
	}

	public void add(Identificateur e, Symbole s) {
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
		for(Entry<Identificateur, Symbole> m : this.dictionnary.entrySet()){
			m.getValue().setIdBlock(idBlock);
			m.getValue().setDeplacement(deplacement);
			deplacement += m.getValue().getTaille();
		}
	}
	
	public Symbole identifier(Identificateur e) {
		
		if(this.dictionnary.containsKey(e))
			return this.dictionnary.get(e);
		
		
		if(this.father != null)
			return this.father.identifier(e);
		else
			return null;
			
		
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("idBlock = " + idBlock + "\n");
		for(Entry<Identificateur, Symbole> m : this.dictionnary.entrySet()){
			s.append("\t" + m.getKey() + "\t\t=>\t" + m.getValue() + "\n");
		}
		
		s.append("\n");
		
		for(LocalDictionnary ld : children){
			s.append(ld.toString());
		}
		
		return s.toString();
	}
}
