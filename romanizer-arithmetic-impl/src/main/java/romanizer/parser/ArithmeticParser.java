package romanizer.parser;

import romanizer.token.Expression;
import romanizer.token.Token;

import java.util.Deque;

/**
 * {@link Parser} for arithmetic expressions.
 */
public interface ArithmeticParser extends Parser<Expression<Integer>, Integer> {

   static int parse(Deque<Expression<Integer>> expressions) {
      return expressions.stream()
            .mapToInt(Token::getValue)
            .sum();
   }

}
