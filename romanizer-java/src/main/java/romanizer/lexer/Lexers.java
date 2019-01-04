package romanizer.lexer;

import romanizer.token.RomanLiteral;

/**
 * Provides factory methods for {@link Lexer}s.
 */
public interface Lexers {

   /**
    * Returns roman {@link Lexer}.
    *
    * @return Lexer
    */
   static Lexer<CharSequence, RomanLiteral> roman() {
      return RomanLexer::lex;
   }

}
