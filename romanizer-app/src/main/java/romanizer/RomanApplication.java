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

   /**
    * RomanApplication.
    *
    * @param args List of command line arguments
    */
   public static void main(final String... args) {

      Converter<String, String> converter = RomanConverter.toDecimal();

      while (true) {

         System.out.println("enter roman number:");

         Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8.name());
         String input = scanner.nextLine();
         String output = converter.convert(input);

         System.out.println(output);

      }
   }

}

