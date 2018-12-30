package romanizer.printer;

/**
 * Integer printers.
 */
public interface IntegerPrinters {

   /**
    * Returns a binary printer.
    *
    * @param <N> Type of input
    * @return Printer
    */
   static <N extends Integer> Printer<N, String> ofBin() {
      return Integer::toBinaryString;
   }

   /**
    * Returns a octal printer.
    *
    * @param <N> Type of input
    * @return Printer
    */
   static <N extends Integer> Printer<N, String> ofOct() {
      return Integer::toOctalString;
   }

   /**
    * Returns a decimal printer.
    *
    * @param <N> Type of input
    * @return Printer
    */
   static <N extends Integer> Printer<N, String> ofDec() {
      return n -> n.toString();
   }

   /**
    * Returns a hexadecimal printer.
    *
    * @param <N> Type of input
    * @return Printer
    */
   static <N extends Integer> Printer<N, String> ofHex() {
      return Integer::toHexString;
   }

}
