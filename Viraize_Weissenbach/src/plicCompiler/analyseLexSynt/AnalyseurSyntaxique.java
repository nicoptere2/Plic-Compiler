
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Fri Apr 10 17:36:44 CEST 2015
//----------------------------------------------------

package plicCompiler.analyseLexSynt;

import plicCompiler.arbreAbstrait.ArbreAbstrait;
import plicCompiler.arbreAbstrait.expression.Expression;
import plicCompiler.arbreAbstrait.expression.constante.ConstanteArithmetique;
import plicCompiler.arbreAbstrait.expression.constante.ConstanteLogique;
import plicCompiler.arbreAbstrait.expression.operation.operationUnaire.ExpressionNegative;
import plicCompiler.arbreAbstrait.expression.operation.operationUnaire.Not;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique.Add;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique.Mul;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique.Sub;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.arithmetique.Div;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison.Equal;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison.GreaterThan;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison.LowerThan;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.comparaison.Different;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.logique.And;
import plicCompiler.arbreAbstrait.expression.operation.operationBinaire.logique.Or;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Fri Apr 10 17:36:44 CEST 2015
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\017\000\002\002\004\000\002\002\004\000\002\003" +
    "\003\000\002\003\003\000\002\003\003\000\002\003\005" +
    "\000\002\003\005\000\002\003\005\000\002\003\005\000" +
    "\002\003\005\000\002\003\005\000\002\003\005\000\002" +
    "\003\005\000\002\003\005\000\002\003\004" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\014\005\012\014\007\020\006\021\011\022" +
    "\010\001\002\000\004\002\037\001\002\000\024\004\036" +
    "\007\022\010\024\011\021\012\016\013\017\014\014\016" +
    "\023\017\020\001\002\000\026\004\uffff\006\uffff\007\uffff" +
    "\010\uffff\011\uffff\012\uffff\013\uffff\014\uffff\016\uffff\017" +
    "\uffff\001\002\000\014\005\012\014\007\020\006\021\011" +
    "\022\010\001\002\000\026\004\ufffd\006\ufffd\007\ufffd\010" +
    "\ufffd\011\ufffd\012\ufffd\013\ufffd\014\ufffd\016\ufffd\017\ufffd" +
    "\001\002\000\026\004\ufffe\006\ufffe\007\ufffe\010\ufffe\011" +
    "\ufffe\012\ufffe\013\ufffe\014\ufffe\016\ufffe\017\ufffe\001\002" +
    "\000\014\005\012\014\007\020\006\021\011\022\010\001" +
    "\002\000\024\006\015\007\022\010\024\011\021\012\016" +
    "\013\017\014\014\016\023\017\020\001\002\000\014\005" +
    "\012\014\007\020\006\021\011\022\010\001\002\000\026" +
    "\004\ufff4\006\ufff4\007\ufff4\010\ufff4\011\ufff4\012\ufff4\013" +
    "\ufff4\014\ufff4\016\ufff4\017\ufff4\001\002\000\014\005\012" +
    "\014\007\020\006\021\011\022\010\001\002\000\014\005" +
    "\012\014\007\020\006\021\011\022\010\001\002\000\014" +
    "\005\012\014\007\020\006\021\011\022\010\001\002\000" +
    "\014\005\012\014\007\020\006\021\011\022\010\001\002" +
    "\000\014\005\012\014\007\020\006\021\011\022\010\001" +
    "\002\000\014\005\012\014\007\020\006\021\011\022\010" +
    "\001\002\000\014\005\012\014\007\020\006\021\011\022" +
    "\010\001\002\000\026\004\ufff7\006\ufff7\007\ufff7\010\ufff7" +
    "\011\ufff7\012\016\013\ufff7\014\ufff7\016\023\017\020\001" +
    "\002\000\026\004\ufffa\006\ufffa\007\ufffa\010\ufffa\011\ufffa" +
    "\012\016\013\ufffa\014\ufffa\016\ufffa\017\ufffa\001\002\000" +
    "\026\004\ufff8\006\ufff8\007\ufff8\010\ufff8\011\ufff8\012\016" +
    "\013\ufff8\014\ufff8\016\023\017\020\001\002\000\026\004" +
    "\ufff6\006\ufff6\007\ufff6\010\ufff6\011\ufff6\012\016\013\ufff6" +
    "\014\ufff6\016\023\017\020\001\002\000\026\004\ufff9\006" +
    "\ufff9\007\ufff9\010\ufff9\011\ufff9\012\016\013\ufff9\014\ufff9" +
    "\016\ufff9\017\ufff9\001\002\000\026\004\ufffc\006\ufffc\007" +
    "\ufffc\010\ufffc\011\ufffc\012\016\013\ufffc\014\ufffc\016\023" +
    "\017\020\001\002\000\026\004\ufff5\006\ufff5\007\ufff5\010" +
    "\ufff5\011\ufff5\012\ufff5\013\ufff5\014\ufff5\016\ufff5\017\ufff5" +
    "\001\002\000\026\004\ufffb\006\ufffb\007\ufffb\010\ufffb\011" +
    "\ufffb\012\016\013\ufffb\014\ufffb\016\023\017\020\001\002" +
    "\000\026\004\ufff3\006\ufff3\007\ufff3\010\ufff3\011\ufff3\012" +
    "\ufff3\013\ufff3\014\ufff3\016\ufff3\017\ufff3\001\002\000\004" +
    "\002\000\001\002\000\004\002\001\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\035\000\006\002\003\003\004\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\034" +
    "\001\001\000\002\001\001\000\002\001\001\000\004\003" +
    "\012\001\001\000\002\001\001\000\004\003\033\001\001" +
    "\000\002\001\001\000\004\003\032\001\001\000\004\003" +
    "\031\001\001\000\004\003\030\001\001\000\004\003\027" +
    "\001\001\000\004\003\026\001\001\000\004\003\025\001" +
    "\001\000\004\003\024\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    /* Change the method report_error so it will display the line and column of where the error
       occurred in the input as well as the reason for the error which is passed into the method
       in the String 'message'. */
    public void report_error(String message, Object info) {
   
        /* Create a StringBuffer called 'm' with the string 'Error' in it. */
        StringBuffer m = new StringBuffer("Error");
   
        /* Check if the information passed to the method is the same type as the type 
           java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the information in the object 
               info that is being typecasted as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
            /* Check if the line number in the input is greater or equal to zero. */
            if (s.left >= 0) {                
                /* Add to the end of the StringBuffer error message the line number of the error 
                   in the input. */
                m.append(" in line "+(s.left+1));   
                /* Check if the column number in the input is greater or equal to zero. */
                if (s.right >= 0)                    
                    /* Add to the end of the StringBuffer error message the column number of the 
                       error in the input. */
                    m.append(", column "+(s.right+1));
            }
        }
        /* Add to the end of the StringBuffer error message created in this method the message that
           was passed into this method. */
        m.append(" : "+message);
   
        /* Print the contents of the StringBuffer 'm', which contains an error message, out on 
           a line. */
        System.err.println(m);
    }
    /* Change the method report_fatal_error so when it reports a fatal error it will display the 
       line and column number of where the fatal error occurred in the input as well as the reason
       for the fatal error which is passed into the method in the object 'message' and then exit.*/
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        //System.exit(1);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalyseurSyntaxique$actions {

 /* vide pour le moment */
	    
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPR ::= MINUS EXPR 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new ExpressionNegative(e);
				
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPR ::= PAROUV EXPR PARFER 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		
		         	RESULT = e;
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPR ::= EXPR EQUAL EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Equal(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPR ::= EXPR INF EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new LowerThan(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPR ::= EXPR SUP EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new GreaterThan(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPR ::= EXPR DIFF EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Different(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPR ::= EXPR DIV EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Div(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPR ::= EXPR MUL EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Mul(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXPR ::= EXPR MINUS EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Sub(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // EXPR ::= EXPR PLUS EXPR 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new Add(e1,e2);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // EXPR ::= FAUX 
            {
              Expression RESULT =null;
		
					RESULT = new ConstanteLogique("0");
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // EXPR ::= VRAI 
            {
              Expression RESULT =null;
		
					RESULT = new ConstanteLogique("1");
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // EXPR ::= CSTE 
            {
              Expression RESULT =null;
		int cleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int cright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String c = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		
					RESULT = new ConstanteArithmetique(c);
		        
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXPR",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // PROG ::= EXPR POINTVIRGULE 
            {
              ArbreAbstrait RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		
					RESULT = e;
				
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("PROG",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= PROG EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		ArbreAbstrait start_val = (ArbreAbstrait)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

