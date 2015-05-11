package plicCompiler.arbreAbstrait.expression.constante;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

import plicCompiler.arbreAbstrait.ArbreAbstrait;

public class ListChaine {
	
	private static ListChaine instance = null;
	
	private ArrayList<ConstanteChaine> listChaine;
	
	private int indice = 0;
	
	private ListChaine() {
		listChaine = new ArrayList<ConstanteChaine>();
	}
	
	public static ListChaine getInstance() {
		if(instance == null)
			instance = new ListChaine();
		
		return instance;
	}
	
	public String push(ConstanteChaine c) {
		listChaine.add(c);
		return "str" + indice++;
	}
	
	public String toCode() {
		StringBuilder s = new StringBuilder();
		int i = 0;
		
		for(ConstanteChaine c: listChaine){
			s.append("str" + i++ + ":" + c.toCode() + "\n");
		}
		
		return s.toString();
	}
}
