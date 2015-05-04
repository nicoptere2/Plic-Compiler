package plicCompiler.arbreAbstrait.instruction;

import java.util.ArrayList;

import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;

public class ListeInstruction {
	private ArrayList<Instruction> instructions;
	
	public ListeInstruction() {
		instructions = new ArrayList<Instruction>();
	}
	
	public void add(Instruction inst) {
		this.instructions.add(inst);
	}
	
	public String toCode() {
		StringBuilder s = new StringBuilder();
		for(Instruction i : instructions)
			s.append(i.toCode());
		
		return s.toString(); 
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		for(Instruction i: instructions)
			s.append(i);
		
		return s.toString();
	}

	public void check() throws TypeIncompatibleException {
		for(Instruction i: instructions)
			i.check();
	}
}
