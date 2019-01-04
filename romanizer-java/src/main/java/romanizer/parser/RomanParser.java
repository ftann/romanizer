package romanizer.parser;

import romanizer.token.RomanLiteral;

import java.util.Collection;
import java.util.Deque;

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
   static int parse(Deque<? extends RomanLiteral> tokens) {

      int value = 0;

      while (!tokens.isEmpty()) {
         value += step(tokens);
      }

      return value;
   }

   /**
    * Advances parser a step. Returns the parsed value.
    *
    * @param tokens Stack of tokens
    * @return Value
    */
   static int step(Deque<? extends RomanLiteral> tokens) {
      RomanLiteral current = tokens.pop();
      if (isSubtractiveNotation(current, tokens.peek())) {
         RomanLiteral next = tokens.pop();
         return next.getValue() - current.getValue();
      } else {
         return current.getValue();
      }
   }

   /**
    * Returns whether the provided tokens are part of subtractive notation.
    *
    * @param token Token
    * @param nextToken Next token
    * @return {@code true} if tokens are part of subtractive notation
    */
   static boolean isSubtractiveNotation(final RomanLiteral token, final RomanLiteral nextToken) {
      return token == RomanLiteral.I && (nextToken == RomanLiteral.V || nextToken == RomanLiteral.X)
            || token == RomanLiteral.X && (nextToken == RomanLiteral.L || nextToken == RomanLiteral.C)
            || token == RomanLiteral.C && (nextToken == RomanLiteral.D || nextToken == RomanLiteral.M);
   }

}
