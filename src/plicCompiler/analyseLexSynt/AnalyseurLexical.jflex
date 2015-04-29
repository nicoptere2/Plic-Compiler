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
mot = {lettre}+
chaine = mot (mot*)

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

";"							{ return symbol(CodesLexicaux.POINTVIRGULE); }


{parouv}					{ return symbol(CodesLexicaux.PAROUV); }

{parfer}					{ return symbol(CodesLexicaux.PARFER); }

{equal}						{ return symbol(CodesLexicaux.EQUAL); }

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






public						{ return symbol(CodesLexicaux.PUBLIC); }

prive						{ return symbol(CodesLexicaux.PRIVE); }

entier						{ return symbol(CodesLexicaux.ENTIER); }

ecrire						{ return symbol(CodesLexicaux.ECRIREIDF); }

lire						{ return symbol(CodesLexicaux.LIREIDF); }

class						{ return symbol(CodesLexicaux.CLASSEIDF); }

{chaine}					{ return symbol(CodesLexicaux.CHAINE, yytext()); }

{mot}						{ return symbol(CodesLexicaux.IDF, yytext()); }

{number}+					{ return symbol(CodesLexicaux.CSTE, yytext()); }

.							{}
\n 							{}

