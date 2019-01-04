package romanizer.token;

/**
 * Roman literals.
 */
public enum RomanLiteral implements Token {

   /**
    * Neutral element.
    * Although it does not exist in the original roman number system,
    * it is used to produce a neutral element.
    */
   NIHIL(0),

   // Standard literals.
   I(1),
   V(5),
   X(10),
   L(50),
   C(100),
   D(500),
   M(1000);

   private final int value;

   /**
    * Creates enum entry with provided value.
    *
    * @param value Value of token
    */
   RomanLiteral(final int value) {
      this.value = value;
   }

   /**
    * Returns token value.
    *
    * @return Value
    */
   public int getValue() {
      return value;
   }

}
