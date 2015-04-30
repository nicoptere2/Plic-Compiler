package plicCompiler.tDS;

public class Symbole {
	
	public static enum Type {ENTIER;};

	public Type type;
	
	public static enum Statue {PRIVE, PUBLIC;};
	
	private Statue statue;
	
	
	private int deplacement;
	
	private int idBlock;
	
	private int numImbrication;
	
	public Symbole (Statue statue, Type type) {
		this.type = type;
		this.statue = statue;
	}
	
	@Override
	public String toString() {
		return statue.toString() + " " + type.toString() + " ";
	}
}
