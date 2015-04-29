package plicCompiler.tDS;

public class TDS {
	
	private static TDS instance = null;
	
	private LocalDictionnary currentBlock;
	
	private int idBlock = 0;
	
	public static TDS getInstance() {
		if(TDS.instance == null)
			TDS.instance = new TDS();
		
		return instance;
	}
	
	private TDS() {
		this.currentBlock = new LocalDictionnary();
	}
	
	public void entrerBlock() {
		idBlock++;
		
		currentBlock = currentBlock.newChild(idBlock);
	}
	
	public void sortirBlock() {
		currentBlock = currentBlock.getFather();
	}
	
	public void ajouter(Entre e, Symbole s) {
		currentBlock.add(e,s);
	}
}
