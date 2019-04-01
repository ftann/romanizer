package romanizer.lexer;

import romanizer.token.Token;

import java.util.Deque;
import java.util.function.Function;

/**
 * Standardized interface for lexical analysis.
 *
 * <p>A {@link Lexer} iterates over an input and performs tokenization.
 *
 * @param <I> Type of input
 * @param <T> Type of output
 */
@FunctionalInterface
public interface Lexer<I extends CharSequence, T extends Token> extends Function<I, Deque<T>> {
}
