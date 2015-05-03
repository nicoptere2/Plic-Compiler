package plicCompiler.tDS;

public class Symbole implements Cloneable{
	
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
	
	

	/**
	 * @param type
	 * @param statue
	 * @param deplacement
	 * @param idBlock
	 * @param numImbrication
	 */
	private Symbole(Type type, Statue statue, int deplacement, int idBlock,
			int numImbrication) {
		this.type = type;
		this.statue = statue;
		this.deplacement = deplacement;
		this.idBlock = idBlock;
		this.numImbrication = numImbrication;
	}

	public void setDeplacement(int deplacement) {
		this.deplacement = deplacement;
	}
	
	public String getDeplacement() {
		return String.valueOf(deplacement);
	}
	
	/**
	 * @return the statue
	 */
	public Statue getStatue() {
		return statue;
	}

	/**
	 * @param statue the statue to set
	 */
	public void setStatue(Statue statue) {
		this.statue = statue;
	}

	/**
	 * @return the idBlock
	 */
	public int getIdBlock() {
		return idBlock;
	}

	/**
	 * @param idBlock the idBlock to set
	 */
	public void setIdBlock(int idBlock) {
		this.idBlock = idBlock;
	}

	/**
	 * @return the numImbrication
	 */
	public int getNumImbrication() {
		return numImbrication;
	}

	/**
	 * @param numImbrication the numImbrication to set
	 */
	public void setNumImbrication(int numImbrication) {
		this.numImbrication = numImbrication;
	}

	public int getTaille() {
		return 4;
	}
	
	@Override
	public Symbole clone() {
		return new Symbole(this.type, this.statue, this.deplacement, this.idBlock, this.numImbrication);
	}
	
	@Override
	public String toString() {
		return statue.toString() + " " + type.toString() + " depl(" + deplacement + ") " + idBlock;
	}
}
