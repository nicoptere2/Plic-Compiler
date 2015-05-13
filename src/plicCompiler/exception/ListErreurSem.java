package plicCompiler.exception;

import java.util.ArrayList;

public class ListErreurSem {
	
	private static ListErreurSem instance = null;

	ArrayList<ErreurSem> list;
	
	private ListErreurSem () {
		list = new ArrayList<ErreurSem>();
	}
	
	public static ListErreurSem getInstance() {
		if(instance == null)
			instance = new ListErreurSem();
		
		return instance;
	}
	
	public void add(String message, String ligne) {
		list.add(new ErreurSem(message, ligne));
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(ErreurSem e: list)
			s.append(e.toString() + "\n");
		
		return s.toString();
	}
}
