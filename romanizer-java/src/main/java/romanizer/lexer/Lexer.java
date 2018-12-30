package romanizer.lexer;

/**
 * Standardized interface for lexical analysis.
 *
 * <p>A {@link Lexer} iterates over an input and performs tokenization.
 *
 * @param <C> Type of input
 * @param <N> Type of output
 */
public interface Lexer<C extends CharSequence, N extends Integer> {

   /**
    * Performs lexical analysis and returns a tokenized output.
    *
    * @param input Raw input
    * @return Tokenized output as number
    */
   N lex(final C input);

}
