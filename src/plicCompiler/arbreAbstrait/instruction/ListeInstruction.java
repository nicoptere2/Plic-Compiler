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
		for(Instruction i: instructions)
			s.append(i.toString());
		
		return s.toString();
	}
}
