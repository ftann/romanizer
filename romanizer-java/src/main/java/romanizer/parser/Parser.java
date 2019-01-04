package romanizer.parser;

import romanizer.token.Token;

import java.util.Collection;
import java.util.Deque;

/**
 * Standardized interface for token parsers.
 *
 * <p>A {@link Parser} reduces a {@link Collection} of {@link Token} into a
 * {@link Collection} of outputs.
 *
 * @param <T> Type of token input
 * @param <V> Type of output
 */
@FunctionalInterface
public interface Parser<T extends Token, V> {

   /**
    * Parses the provided {@link Collection} of tokens.
    *
    * @param tokens {@link Deque} of {@link Token}s
    * @return Collection of parsed values
    */
   V parse(final Deque<? extends T> tokens);

}
