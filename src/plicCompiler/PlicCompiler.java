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
import plicCompiler.analyseSemantique.AnalyseurSemantique;
import plicCompiler.analyseSemantique.exception.TypeIncompatibleException;
import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.arbreAbstrait.expression.constante.ListChaine;
import plicCompiler.tDS.TDS;

/**
 * @author nico
 *
 */
public class PlicCompiler {
	
	private static FileIO file;
	
	public PlicCompiler() {
		
		String code = file.read();
		
		//System.out.println(code);
		
		this.compiler(code);
	}

	private void compiler(String code) {
		AnalyseurSyntaxique analyser = new AnalyseurSyntaxique(new AnalyseurLexical(new StringReader(code)));
		ArbreAbstrait arbreAbstrait = null;
		try {
			arbreAbstrait =  (ArbreAbstrait) analyser.parse().value;
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erreur Analyse LexSynt");
			System.exit(1);
		}
		
		System.out.println("Arbre = \n" + arbreAbstrait.toString());
		
		AnalyseurSemantique analyserSemantique = new AnalyseurSemantique(arbreAbstrait);
		
		System.out.println("Analyse Semantique :");
		
		analyserSemantique.check();
		
		//System.out.println("\n\n" + arbreAbstrait.toString()+ "\n\n");
		
		//System.out.println(TDS.getInstance().toString() + "\n\n");
		
		StringBuilder s = new StringBuilder();
		s.append(".data\n");
		s.append(ListChaine.getInstance().toCode());
		
		s.append(".text\n");
		
		s.append(arbreAbstrait.toCode());
		
		
		try {
			file.write(s.toString());
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("Compilation Effectué");
		System.out.println("Ecriture dans le fichier : " + file.getOutFilename());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenue a notre programmeur Plic!");
		if(args.length != 2){
			System.out.println("Usage : plicCompiler fichierSource fichier destination");
			System.exit(1);
		}
			
		file = new FileIO(args[0], args[1]);
		new PlicCompiler();
	}

}
