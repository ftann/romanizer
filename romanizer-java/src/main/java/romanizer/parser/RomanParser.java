package romanizer.parser;

import romanizer.token.RomanLiteral;

import java.util.Collection;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * {@link Parser} for roman literals.
 */
interface RomanParser {

   /**
    * Parses a {@link Collection} of {@link RomanLiteral}s into an integer.
    *
    * @param tokens Collection of tokens
    * @return Value
    */
   static int parse(final Deque<? extends RomanLiteral> tokens) {
      return step(0, tokens);
   }

   /**
    * Advances parser a step. Returns the parsed value.
    *
    * @param value Already parsed value
    * @param tokens Stack of remaining tokens
    * @return Value
    */
   private static int step(final int value, final Deque<? extends RomanLiteral> tokens) {
      if (tokens.isEmpty()) {
         return value;
      }

      int result;
      var cont = new ConcurrentLinkedDeque<>(tokens);

      var current = cont.pop();
      if (isSubtractiveNotation(current, cont.peek())) {
         result = cont.pop().getValue() - current.getValue();
      } else {
         result = current.getValue();
      }

      return step(value + result, cont);
   }

   /**
    * Returns whether the provided tokens are part of subtractive notation.
    *
    * @param token Token
    * @param nextToken Next token
    * @return {@code true} if tokens are part of subtractive notation
    */
   private static boolean isSubtractiveNotation(final RomanLiteral token, final RomanLiteral nextToken) {
      return token == RomanLiteral.I && (nextToken == RomanLiteral.V || nextToken == RomanLiteral.X)
            || token == RomanLiteral.X && (nextToken == RomanLiteral.L || nextToken == RomanLiteral.C)
            || token == RomanLiteral.C && (nextToken == RomanLiteral.D || nextToken == RomanLiteral.M);
   }

}
