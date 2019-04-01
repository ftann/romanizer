package romanizer.converter;

import romanizer.lexer.Lexer;
import romanizer.parser.Parser;
import romanizer.token.Token;

import java.util.function.Function;

/**
 * Converts values based on provided lexer and printer.
 *
 * @param <I> Type of input
 * @param <O> Type of output
 */
@FunctionalInterface
public interface Converter<I extends CharSequence, O> extends Function<I, O> {

   /**
    * Returns converter that converts values based on provided lexer and
    * printer.
    *
    * @param <I> Type of input
    * @param <T> Type of intermediate result
    * @param <O> Type of output
    * @param lexer {@link Lexer} Tokenizing input
    * @param parser {@link Parser} Parsing tokens
    * @return Converter that converts values based on provided lexer, parser and
    *       printer.
    */
   static <I extends CharSequence, T extends Token, O> Function<I, O> build(final Lexer<I, T> lexer, final Parser<T, O> parser) {
      return lexer.andThen(parser);
   }

}
