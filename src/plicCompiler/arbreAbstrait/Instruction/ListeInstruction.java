package plicCompiler.arbreAbstrait.Instruction;

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
}
