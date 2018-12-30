package romanizer.lexer;

/**
 * Lexer of roman numbers.
 */
public interface RomanLexer {

   /**
    * Returns roman lexer.
    *
    * @return Lexer
    */
   static Lexer<String, Integer> of() {
      return RomanLexer::lexRoman;
   }

   /**
    * Performs lexical analysis of input string and returns number.
    *
    * @param roman Roman number
    * @return Number
    */
   @SuppressWarnings("PMD")
   static int lexRoman(String roman) {

      int result = 0;

      for (int i = 0; i < roman.length(); i++) {

         String current = roman.substring(i, i + 1);
         String next = lookAhead(roman, i);

         Literal literal = nextLiteral(current, next);

         if (Literal.isSubtractiveNotationLiteral(literal)) {
            i++;
         }

         result += literal.getValue();
      }

      return result;
   }

   /**
    * Returns next token.
    *
    * @param roman Roman number
    * @param index Index
    * @return Next
    */
   static String lookAhead(String roman, int index) {
      if (index + 1 < roman.length()) {
         return roman.substring(index + 1, index + 2);
      } else {
         return "";
      }
   }

   /**
    * Returns the next literal.
    *
    * @param current Current
    * @param next Next
    * @return Literal
    */
   static Literal nextLiteral(String current, String next) {
      Literal literal;

      switch (current) {
         // With subtractive notation.
         case "I":
            switch (next) {

               case "V":
                  literal = Literal.IV;
                  break;

               case "X":
                  literal = Literal.IX;
                  break;

               default:
                  literal = Literal.I;
                  break;
            }
            break;

         case "X":
            switch (next) {

               case "L":
                  literal = Literal.XL;
                  break;

               case "C":
                  literal = Literal.XC;
                  break;

               default:
                  literal = Literal.X;
                  break;
            }
            break;

         case "C":
            switch (next) {

               case "D":
                  literal = Literal.CD;
                  break;

               case "M":
                  literal = Literal.CM;
                  break;

               default:
                  literal = Literal.C;
                  break;
            }
            break;

         // Witout subtractive notation.
         case "V":
            literal = Literal.V;
            break;

         case "L":
            literal = Literal.L;
            break;

         case "D":
            literal = Literal.D;
            break;

         case "M":
            literal = Literal.M;
            break;

         default:
            literal = Literal.O;
            break;
      }

      return literal;
   }

   /**
    * Roman literals.
    */
   enum Literal {

      // Standard.
      O("", 0),
      I("I", 1),
      V("V", 5),
      X("X", 10),
      L("L", 50),
      C("C", 100),
      D("D", 500),
      M("M", 1000),

      // Subtractive notation.
      IV("IV", 4),
      IX("IX", 9),
      XL("XL", 40),
      XC("XC", 90),
      CD("CD", 400),
      CM("CM", 900);

      /**
       * Representation of literal.
       */
      private final String representation;

      /**
       * Value of literal.
       */
      private final int value;

      /**
       * Creates a new instance of a roman literal.
       *
       * @param representation Representation
       * @param value Value
       */
      Literal(final String representation, final int value) {
         this.representation = representation;
         this.value = value;
      }

      /**
       * Returns the representation of the literal.
       *
       * @return Representation
       */
      String getRepresentation() {
         return representation;
      }

      /**
       * Returns the value of the literal.
       *
       * @return Value
       */
      int getValue() {
         return value;
      }

      /**
       * Returns whether a literal is written in subtractive notation.
       *
       * @param literal Literal
       * @return Whether literal is written in subtractive notation
       */
      static boolean isSubtractiveNotationLiteral(Literal literal) {
         return IV == literal || IX == literal
               || XL == literal || XC == literal
               || CD == literal || CM == literal;
      }
   }

}
