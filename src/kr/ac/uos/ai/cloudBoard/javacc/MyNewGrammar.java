/* Generated By:JavaCC: Do not edit this line. MyNewGrammar.java */
package kr.ac.uos.ai.cloudBoard.javacc;

import kr.ac.uos.ai.cloudBoard.astNode.*;
import java.util.*;

public class MyNewGrammar implements MyNewGrammarConstants {
  public static void main(String args []) throws ParseException
  {
    System.out.println("input : ");
    MyNewGrammar parser = new MyNewGrammar(System.in);
      try
      {
        CodeBlock c =  MyNewGrammar.codeBlock();
                System.out.println(c);
        StatementCode code = c.getStatements().get(0);
        System.out.println(((Assignment)code).getLeft());
        System.out.println(((Assignment)code).getRight());
        }
      catch (Exception e)
      {
        e.printStackTrace();

      }
      catch (Error e)
      {
        e.printStackTrace();
      }
  }

  static final public CodeBlock codeBlock() throws ParseException {
  CodeBlock block = new CodeBlock();
  LinkedList< StatementCode > list = null;
    list = statements();
    jj_consume_token(END);
           block.setStatements(list);
          {if (true) return block;}
    throw new Error("Missing return statement in function");
  }

  static final public LinkedList<StatementCode > statements() throws ParseException {
  LinkedList<StatementCode > list = new LinkedList<StatementCode >();
  StatementCode code = null;
    label_1:
    while (true) {
      code = statement();
      jj_consume_token(SEMICOLON);
            list.add(code);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case IDENTIFIER:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
    }
  {if (true) return list;}
    throw new Error("Missing return statement in function");
  }

  static final public StatementCode statement() throws ParseException {
  StatementCode code = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case WHILE:
      whileStatement();
      break;
    case IF:
      ifStatement();
      break;
    case IDENTIFIER:
      code = assignmentStatement();
          {if (true) return code;}
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public void ifStatement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(IDENTIFIER);
  }

  static final public void whileStatement() throws ParseException {
    whileStatementCondition();
    whileStatementBlock();
  }

  static final public void whileStatementCondition() throws ParseException {
    jj_consume_token(WHILE);
    jj_consume_token(LPAREN);
    expression();
    jj_consume_token(RPAREN);
  }

  static final public void whileStatementBlock() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
      jj_consume_token(LBRACE);
      statements();
      jj_consume_token(RBRACE);
      break;
    case IF:
    case WHILE:
    case IDENTIFIER:
      statement();
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public Assignment assignmentStatement() throws ParseException {
  Assignment assign = new Assignment();
  Token t;
  ExpressionCode exp;
    t = jj_consume_token(IDENTIFIER);
    jj_consume_token(ASSIGN);
    exp = expression();
    assign.setLeft(t.image);
    assign.setRight(exp);
    {if (true) return assign;}
    throw new Error("Missing return statement in function");
  }

  static final public ExpressionCode expression() throws ParseException {
  ExpressionCode exp = new ExpressionCode();
  Token t = null;
    t = jj_consume_token(INTEGER_LITERAL);
    exp.setValue(t.image);
    {if (true) return exp;}
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MyNewGrammarTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x10c00,0x10c00,0x210c00,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,};
   }

  /** Constructor with InputStream. */
  public MyNewGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public MyNewGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public MyNewGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MyNewGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public MyNewGrammar(MyNewGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MyNewGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[52];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 52; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
