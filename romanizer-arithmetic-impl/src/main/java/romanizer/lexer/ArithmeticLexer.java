package romanizer.lexer;

import romanizer.token.Addition;
import romanizer.token.Expression;
import romanizer.token.Literal;

import java.util.Deque;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * {@link Lexer} for arithmetic expressions.
 */
public interface ArithmeticLexer extends Lexer<CharSequence, Expression> {

   /**
    * Performs lexical analysis of input string and returns {@link Deque}
    * of {@link Expression}s.
    *
    * @param expression Arithmetic expression
    * @return Deque of expressions
    */
   static Deque<Expression<Integer>> lex(CharSequence expression) {
      return step(new ConcurrentLinkedDeque<>(), expression);
   }

   private static Deque<Expression<Integer>> step(final Deque<Expression<Integer>> expressions, final CharSequence cont) {

      final var stringTokenizer = new StringTokenizer(cont.toString(), "+", true);

      // 1 + 2
      // Literal(1), Addition(<, >), Literal(2)
      // TODO

      while (stringTokenizer.hasMoreTokens()) {
         final var element = stringTokenizer.nextToken();

         if (element.length() != 1) {
            // expressions.add(new Literal(Integer.valueOf(element)));
         }
      }

      expressions.add(
            new Addition(
                  new Literal(1),
                  new Literal(2)));


      return expressions;
   }

}
