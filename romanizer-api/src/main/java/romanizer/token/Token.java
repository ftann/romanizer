package romanizer.token;

/**
 * Defines a token.
 * {@link romanizer.lexer.Lexer} perform analysis that produces tokens.
 *
 * @param <T> Type of token value
 */
public interface Token<T> {

   /**
    * Returns token value.
    *
    * @return Value
    */
   T getValue();

}
