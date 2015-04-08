package plicCompiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {
	
	private String filename;
	
	@SuppressWarnings("resource")
	public String read(String f) {
		
		filename = f;
		
		StringBuilder code = new StringBuilder();
		BufferedReader br = null;
		String buff = "";
		
		try {
			br = new BufferedReader(new FileReader(filename+".plic"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Impossible d'ouvrir le fichier");
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
		
		String f = filename;
		boolean done = false;
		int i=0;
		
		File file;
		
		do {
			if(i!=0)
				f = filename+i;
			
			file = new File(f +".asm");
	    	try {
				if(file.createNewFile()){
					System.out.println("file created : " + f + ".asm");
					done = true;
				}else{
					System.out.println("file already exists");
					i++;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while(!done);
    	
    	FileWriter fw;
    	fw = new FileWriter(file.getAbsoluteFile());
    	BufferedWriter writer = new BufferedWriter(fw);
    	
    	writer.write(code);

		writer.close();
	
	}
}
