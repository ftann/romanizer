package romanizer.token;

public class Literal extends Expression<Integer> {

   private final int value;

   public Literal(final int value) {
      this.value = value;
   }

   @Override
   public Integer getValue() {
      return value;
   }
}
