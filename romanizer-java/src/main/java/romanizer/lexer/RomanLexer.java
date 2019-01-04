package romanizer.lexer;

import static java.util.stream.Collectors.toCollection;

import romanizer.token.RomanLiteral;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * {@link Lexer} for roman numbers.
 */
interface RomanLexer {

   /**
    * Performs lexical analysis of input string and returns {@link Deque}
    * of {@link romanizer.token.Token}s.
    *
    * @param roman Roman number
    * @return Deque of tokens
    */
   static Deque<RomanLiteral> lex(CharSequence roman) {
      return roman.chars()
            .mapToObj(RomanLexer::tokenize)
            .collect(toCollection(ConcurrentLinkedDeque::new));
   }

   /**
    * Returns the {@link RomanLiteral} that matches the input.
    *
    * @param input Raw token
    * @return Roman literal token
    */
   static RomanLiteral tokenize(final int input) {
      switch (input) {
         case 'i':
         case 'I':
            return RomanLiteral.I;
         case 'v':
         case 'V':
            return RomanLiteral.V;
         case 'x':
         case 'X':
            return RomanLiteral.X;
         case 'l':
         case 'L':
            return RomanLiteral.L;
         case 'c':
         case 'C':
            return RomanLiteral.C;
         case 'd':
         case 'D':
            return RomanLiteral.D;
         case 'm':
         case 'M':
            return RomanLiteral.M;
         default:
            return RomanLiteral.NIHIL;
      }
   }

}
