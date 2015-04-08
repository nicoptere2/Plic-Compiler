/**
 * 
 */
package plicCompiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.IOException;

import plicCompiler.analyseLexSynt.AnalyseurLexical;
import plicCompiler.analyseLexSynt.AnalyseurSyntaxique;
import plicCompiler.arbreAbstrait.ArbreAbstrait;

/**
 * @author nico
 *
 */
public class PlicCompiler {
	
	private FileIO file;
	
	public PlicCompiler(String filename) {
		
		System.out.println("fdkslqfmsdklm");
		
		file = new FileIO();
		
		String code = file.read(filename);
		
		System.out.println(code);
		
		this.compiler(code);
	}

	private void compiler(String code) {
		AnalyseurSyntaxique analyser = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(code)));
		ArbreAbstrait arbreAbstrait = null;
		try {
			arbreAbstrait =  (ArbreAbstrait) analyser.parse().value;
			//System.out.println(arbreAbstrait.toString());
			//System.out.println(arbreAbstrait.toCode());
			
			file.write(arbreAbstrait.toCode());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur Analyse LexSynt");
			System.exit(1);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue a notre programmeur Plic!");
		if(args.length == 0) {
			System.out.println("arg1 : fileName");
			new PlicCompiler("test");
		}
		else {
			new PlicCompiler(args[1]);
			
		}
	}

}
