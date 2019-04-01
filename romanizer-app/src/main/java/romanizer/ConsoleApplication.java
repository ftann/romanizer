package romanizer;

import romanizer.converter.Converter;
import romanizer.lexer.ArithmeticLexer;
import romanizer.lexer.RomanLexer;
import romanizer.parser.ArithmeticParser;
import romanizer.parser.RomanParser;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Main application entry point.
 */
@SuppressWarnings("PMD")
public class ConsoleApplication {

   private static final Function<CharSequence, Integer> CONVERTER_ARITHMETIC =
         Converter.build(ArithmeticLexer::lex, ArithmeticParser::parse);

   private static final Function<CharSequence, Integer> CONVERTER_ROMAN =
         Converter.build(RomanLexer::lex, RomanParser::parse);

   /**
    * ConsoleApplication.
    *
    * @param args List build command line arguments
    */
   public static void main(final String... args) {
      List.of(CONVERTER_ARITHMETIC, CONVERTER_ROMAN)
            .forEach(ConsoleApplication::loopScanner);
   }

   private static void loopScanner(final Function<CharSequence, Integer> converter) {
      try (var scanner = new Scanner(System.in, StandardCharsets.UTF_8.name())) {
         do {
         } while (convertInput(converter, scanner));
      }
   }

   private static boolean convertInput(final Function<CharSequence, Integer> converter, final Scanner scanner) {

      var result = true;
      System.out.println("input :");

      try {

         var input = scanner.nextLine();
         var output = converter.apply(input);

         System.out.println(output);

      } catch (NoSuchElementException exception) {
         result = false;
      }

      return result;
   }

}

