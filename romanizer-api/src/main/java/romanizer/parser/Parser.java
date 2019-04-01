package romanizer.parser;

import romanizer.token.Token;

import java.util.Collection;
import java.util.Deque;
import java.util.function.Function;

/**
 * Standardized interface for token parsers.
 *
 * <p>A {@link Parser} reduces a {@link Collection} of {@link Token} into a
 * {@link Collection} of outputs.
 *
 * @param <T> Type of token input
 * @param <O> Type of output
 */
@FunctionalInterface
public interface Parser<T extends Token, O> extends Function<Deque<T>, O> {
}
