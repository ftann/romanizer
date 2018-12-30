package romanizer.printer;

/**
 * Standardized interface for printing values.
 *
 * <p>A {@link Printer} converts an input into a printable output.
 *
 * @param <N> Type of input
 * @param <C> Type of output
 */
@FunctionalInterface
public interface Printer<N extends Number, C extends CharSequence> {

   /**
    * Converts the provided input into a printable output.
    *
    * @param input Raw number
    * @return Printable output
    */
   C print(final N input);

   /**
    * Creates a printer function that uses {@link String#valueOf(Object)} to
    * print a value.
    *
    * @param <N> Type of input
    * @return Printer that leverages {@link String#valueOf(Object)}
    */
   static <N extends Number> Printer<N, String> of() {
      return String::valueOf;
   }

}
