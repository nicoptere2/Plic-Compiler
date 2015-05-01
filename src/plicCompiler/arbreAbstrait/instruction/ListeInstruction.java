package plicCompiler.arbreAbstrait.instruction;

import java.util.ArrayList;

import plicCompiler.arbreAbstrait.ArbreAbstrait;

public class ListeInstruction {
	private ArrayList<Instruction> instructions;
	
	public ListeInstruction() {
		instructions = new ArrayList<Instruction>();
	}
	
	public void add(Instruction inst) {
		this.instructions.add(inst);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		int j=0;
		for(Instruction i: instructions){
			System.out.println(j); j++;
			s.append(i);
		}
		
		return s.toString();
	}
}
