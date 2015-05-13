package plicCompiler.arbreAbstrait.instruction;

import java.util.ArrayList;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.exception.ListErreurSem;
import plicCompiler.exception.SemanticsException;

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

	public void check() {
		for(Instruction i: instructions){
			try {
				i.check();
			} catch (SemanticsException e) {
				ListErreurSem.getInstance().add(e.getMessage(), String.valueOf(i.getLigne()));
				continue;
			}
		}
	}
}
