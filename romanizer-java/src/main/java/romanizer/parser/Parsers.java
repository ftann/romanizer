package romanizer.parser;

import romanizer.token.RomanLiteral;

/**
 * Provides factory methods for {@link Parser}s.
 */
public interface Parsers {

   /**
    * Returns roman {@link Parser}.
    *
    * @return Parser
    */
   static Parser<RomanLiteral, Integer> roman() {
      return RomanParser::parse;
   }

}
