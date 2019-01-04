package romanizer.converter;

import romanizer.lexer.Lexers;
import romanizer.parser.Parsers;

/**
 * Provides converters from roman numbers.
 */
public interface RomanConverter {

   /**
    * Returns {@link Converter} from roman number to integer.
    *
    * @return Converter
    */
   static Converter<CharSequence, Integer> of() {
      return Converter.of(Lexers.roman(), Parsers.roman());
   }

}
