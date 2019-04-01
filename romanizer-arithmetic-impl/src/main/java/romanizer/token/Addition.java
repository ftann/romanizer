package romanizer.token;

public class Addition extends Expression<Integer> {

   private final Expression<Integer> left;
   private final Expression<Integer> right;

   public Addition(final Expression<Integer> left, final Expression<Integer> right) {
      this.left = left;
      this.right = right;
   }

   @Override
   public Integer getValue() {
      return left.getValue() + right.getValue();
   }
}
