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

equal	= ==
diff	= !=
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

{plus}						{ return symbol(CodesLexicaux.PLUS); }

{minus}						{ return symbol(CodesLexicaux.MINUS); }

{mul}						{ return symbol(CodesLexicaux.MUL); }

{div}						{ return symbol(CodesLexicaux.DIV); }





{number}+					{ return symbol(CodesLexicaux.CSTE, yytext()); }

.							{}
\n 							{}

