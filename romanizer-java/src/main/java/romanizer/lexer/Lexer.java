package romanizer.lexer;

import romanizer.token.Token;

import java.util.Deque;

/**
 * Standardized interface for lexical analysis.
 *
 * <p>A {@link Lexer} iterates over an input and performs tokenization.
 *
 * @param <C> Type of input
 * @param <T> Type of output
 */
@FunctionalInterface
public interface Lexer<C extends CharSequence, T extends Token> {

   /**
    * Performs lexical analysis and returns a {@link Deque} of
    * {@link Token}s.
    *
    * @param input Raw input
    * @return Collection of tokens
    */
   Deque<T> lex(final C input);

}
