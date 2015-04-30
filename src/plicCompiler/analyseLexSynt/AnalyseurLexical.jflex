package plicCompiler.analyseLexSynt ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state commentaire

number = [0-9]
lettre = [a-zA-Z]
idf = [a-zA-Z]([a-z|A-Z|0-9])*
mot = lettre+
chaine = ["]mot*["]

affect  = =

equal	= ==
diff	= \!=
inf		= <
sup		= >

plus	= \+
minus	= -

mul		= \*
div		= \/

parouv 	= \(
parfer	= \)


%%

";"							{ System.out.print(";");return symbol(CodesLexicaux.POINTVIRGULE); }
","							{ System.out.print(",");return symbol(CodesLexicaux.VIRGULE); }

{parouv}					{ return symbol(CodesLexicaux.PAROUV); }

{parfer}					{ return symbol(CodesLexicaux.PARFER); }

{equal}						{ System.out.print("=="); return symbol(CodesLexicaux.EQUAL); }

{inf}						{ return symbol(CodesLexicaux.INF); }

{sup}						{ return symbol(CodesLexicaux.SUP); }

{diff}						{ return symbol(CodesLexicaux.DIFF); }

{plus}						{ return symbol(CodesLexicaux.PLUS); }

{minus}						{ return symbol(CodesLexicaux.MINUS); }

{mul}						{ return symbol(CodesLexicaux.MUL); }

{div}						{ return symbol(CodesLexicaux.DIV); }

vrai						{ return symbol(CodesLexicaux.VRAI); }

faux						{ return symbol(CodesLexicaux.FAUX); }

end							{ return symbol(CodesLexicaux.END); }



{affect}						{ System.out.print("=");return symbol(CodesLexicaux.AFFECTIDF); }


publique					{ return symbol(CodesLexicaux.PUBLIC); }

privee						{ return symbol(CodesLexicaux.PRIVE); }

entier						{ return symbol(CodesLexicaux.ENTIER); }

ecrire						{ return symbol(CodesLexicaux.ECRIREIDF); }

lire						{ return symbol(CodesLexicaux.LIREIDF); }

classe						{ System.out.print("classe"); return symbol(CodesLexicaux.CLASSEIDF); }

\"(\\.|[^"])*\"		{ System.out.println("chaine"); return symbol(CodesLexicaux.CHAINE, yytext()); } 

{idf}						{ System.out.print("idf" + yytext()); return symbol(CodesLexicaux.IDF, yytext()); }

{number}+					{ return symbol(CodesLexicaux.CSTE, yytext()); }

.							{ System.out.print("."); }
\n 							{ System.out.println();}

