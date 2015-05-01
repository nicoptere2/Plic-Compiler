package plicCompiler.tDS;

public class Symbole {
	
	public static enum Type {ENTIER, CLASS;};

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
	
	public Symbole (Type type) {
		this.type = type;
		this.statue = Statue.PUBLIC;
	}
	
	@Override
	public String toString() {
		return statue.toString() + " " + type.toString() + " depl(" + deplacement + ") " + idBlock;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}
	
	public String getDeplacement() {
		return String.valueOf(deplacement);
	}

	public int getTaille() {
		return 4;
	}
}
