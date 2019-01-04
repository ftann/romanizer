package romanizer.converter;

import romanizer.lexer.Lexer;
import romanizer.parser.Parser;
import romanizer.token.Token;

/**
 * Converts values based on provided lexer and printer.
 *
 * @param <I> Type of input
 * @param <O> Type of output
 */
@FunctionalInterface
public interface Converter<I, O> {

   /**
    * Returns converter that converts values based on provided lexer and
    * printer.
    *
    * @param <I> Type of input
    * @param <O> Type of output
    * @param <T> Type of intermediate result
    * @param <L> Type of lexer
    * @param <P> Type of parser
    * @param lexer {@link Lexer} Tokenizing input
    * @param parser {@link Parser} Parsing tokens
    * @return Converter that converts values based on provided lexer, parser and
    *       printer.
    */
   static <I extends CharSequence,
         O,
         T extends Token,
         L extends Lexer<I, T>,
         P extends Parser<T, O>
         > Converter<I, O> of(final L lexer, final P parser) {

      return input -> parser.parse(lexer.lex(input));
   }

   /**
    * Converts provided input and returns printable output.
    *
    * @param input Values to be converted
    * @return Printable output
    */
   O convert(final I input);

}
