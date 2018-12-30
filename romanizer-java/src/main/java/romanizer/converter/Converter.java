package romanizer.converter;

import romanizer.lexer.Lexer;
import romanizer.printer.Printer;

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
    * @param <N> Type of intermediate result
    * @param <L> Type of lexer
    * @param <P> Type of printer
    * @param lexer Lexer tokenizing input
    * @param printer Printer converting to printable output
    * @return Converter that converts values based on provided lexer and
    *       printer.
    */
   static <I extends CharSequence,
         O extends CharSequence,
         N extends Integer,
         L extends Lexer<I, N>,
         P extends Printer<N, O>
         > Converter<I, O> of(final L lexer, final P printer) {
      return input -> printer.print(lexer.lex(input));
   }

   /**
    * Converts provided input and returns printable output.
    *
    * @param input Values to be converted
    * @return Printable output
    */
   O convert(final I input);

}
