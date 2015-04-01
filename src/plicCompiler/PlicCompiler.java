/**
 * 
 */
package plicCompiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.io.IOException;

import java_cup.runtime.Symbol;

import plicCompiler.analyseLexSynt.AnalyseurLexical;
import plicCompiler.analyseLexSynt.AnalyseurSyntaxique;
import plicCompiler.arbreAbstrait.ArbreAbstrait;

/**
 * @author nico
 *
 */
public class PlicCompiler {
	
	public PlicCompiler(String fileName) {
		StringBuilder code = new StringBuilder();
		BufferedReader br = null;
		String buff = "";
		
		try {
			br = new BufferedReader(new FileReader(fileName));
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
		};
		
		System.out.println(code.toString());
		
		this.compiler(code.toString());
	}

	private void compiler(String code) {
		AnalyseurSyntaxique analyser = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(code)));
		try {
			ArbreAbstrait arberAbstrait =  (ArbreAbstrait) analyser.parse().value;
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
			new PlicCompiler("test.plic");
		}
		else {
			new PlicCompiler(args[1]);
			
		}
	}

}
