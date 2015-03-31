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

parouv 	= \(
parfer	= \)
equal	= ==
diff	= !=
inf		= <
sup		= >
op		= \+|\-|\*|\/

%%

";"							{ return symbol(CodesLexicaux.POINTVIRGULE); }


{parouv}					{ return symbol(CodesLexicaux.PAROUV); }

{parfer}					{ return symbol(CodesLexicaux.PARFER); }

{equal}						{ return symbol(CodesLexicaux.EGAL); }

{diff}						{ return symbol(CodesLexicaux.DIFF); }

{inf}						{ return symbol(CodeLexicaux.INF); }

{sup}						{ return symbol(CodeLexicaux.SUP)}

{op}						{ return symbol(CodesLexicaux.OP, yytext()); }



{number}+					{ return symbol(CodesLexicaux.CSTE, yytext()); }

.							{}
\n 							{}

