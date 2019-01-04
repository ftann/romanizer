package romanizer;

import romanizer.converter.Converter;
import romanizer.converter.RomanConverter;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main application entry point.
 */
@SuppressWarnings("PMD")
public class RomanApplication {

   private static final Converter<CharSequence, Integer> CONVERTER = RomanConverter.of();

   /**
    * RomanApplication.
    *
    * @param args List of command line arguments
    */
   public static void main(final String... args) {

      boolean isDone = false;

      try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name())) {

         while (!isDone) {
            System.out.println("enter roman number:");

            String input = scanner.nextLine();
            isDone = "".equalsIgnoreCase(input);

            Integer output = CONVERTER.convert(input);

            System.out.println(output);
         }

      }
   }

}

