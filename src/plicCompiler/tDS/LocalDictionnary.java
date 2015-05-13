package plicCompiler.tDS;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;

import plicCompiler.arbreAbstrait.expression.Identificateur;
import plicCompiler.exception.ListErreurSem;

public class LocalDictionnary {
	
	private LocalDictionnary father;
	private Vector<LocalDictionnary> children;
	private int currentChild = 0;
	
	private int taille = 0;
	
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
		return this.children.get(currentChild);
	}

	public LocalDictionnary getFather() {
		this.currentChild = 0;
		return this.father;
	}

	public void add(Identificateur e, Symbole s, int ligne) {
		if(this.dictionnary.containsKey(e))
			ListErreurSem.getInstance().add("Identificateur '" + e.toString() + "' deja instancié", String.valueOf(ligne));
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
		this.taille = deplacement;
	}
	
	public Symbole identifier(Identificateur e) {
		
		if(this.dictionnary.containsKey(e))
			return this.dictionnary.get(e);
		
		
		if(this.father != null)
			return this.father.identifier(e);
		else
			return null;
			
		
	}
	
	public String codeEntre() {
		StringBuilder s = new StringBuilder();
		
		s.append("\n\n");
		
		s.append("# Entre dans un block\n");
		
		s.append("# initialisation @retour\n");
		s.append("sw $s7, ($sp)\n");
		
		s.append("# initialiser s7 avec sp (initialisation de la base des variables)\n");
		s.append("move $s7,$sp\n");
    
		s.append("# r�servation de l'espace pour " + this.dictionnary.size() + " variables\n");
		s.append("addi $sp, $sp, -" + this.taille + "\n");
		
		s.append("# numero de region\n");
		s.append("li $v0, " + this.idBlock + "\n");
		s.append("sw $v0, -8($s7)\n\n\n");
		
		return s.toString();
	}
	
	public String codeSortie() {
		StringBuilder s = new StringBuilder();
		
		s.append("# Sortie d'un block \n");
		
		s.append("# deplacement sommet pile\n");
		s.append("move $sp, $s7\n");
		
		s.append("# deplacement de la base du block\n");
		s.append("lw $s7, ($sp)\n");
		
		return s.toString();
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
