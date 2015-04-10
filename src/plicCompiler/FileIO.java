package plicCompiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

	private String inFilename;
	
	private String outFilename;
	
	public FileIO(String inFilename, String outFilename) {
		super();
		this.inFilename = inFilename;
		this.outFilename = outFilename;
	}	
	
	@SuppressWarnings("resource")
	public String read() {
		
		StringBuilder code = new StringBuilder();
		BufferedReader br = null;
		String buff = "";
		
		try {
			br = new BufferedReader(new FileReader(inFilename));
		} catch (FileNotFoundException e) {
			System.out.println("Erreur : " + e.getMessage());
			System.exit(1);
		}
		
		 while(buff != null) {
			code.append(buff+"\n");
			try {
				buff = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("Impossible de lire le fichier");
				System.exit(1);
			}
		}
		
		return code.toString();
	}

	public void write(String code) throws IOException {
		
		File file;
			
		file = new File(this.outFilename);
    	
    	FileWriter fw;
    	fw = new FileWriter(file.getAbsoluteFile(), false);
    	BufferedWriter writer = new BufferedWriter(fw);
    	
    	writer.write(code);

		writer.close();
	
	}

	public String getOutFilename() {
		return this.outFilename;
	}
}
