package romanizer.converter;

import static romanizer.printer.IntegerPrinters.ofDec;

import romanizer.lexer.RomanLexer;
import romanizer.printer.Printer;

/**
 * Provides converters from roman numbers.
 */
public interface RomanConverter {

   /**
    * Returns {@link Converter} from roman to provided {@link Printer}.
    *
    * @param printer Printer
    * @return Converter
    */
   static Converter<String, String> from(Printer<Integer, String> printer) {
      return Converter.of(RomanLexer.of(), printer);
   }

   /**
    * Returns {@link Converter} from roman to decimal number.
    *
    * @return Converter
    */
   static Converter<String, String> toDecimal() {
      return from(ofDec());
   }

}
