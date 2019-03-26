import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] data = s.split(" ");
      MyDeque<Double> stack = new MyDeque<Double>();
      for (int i = 0; i < data.length; i++) {
        if (isInteger(data[i])) {
          stack.addFirst(Double.valueOf(data[i]));
          System.out.println(stack);
        } else {
          if (data[i].equals("+")) {
            stack.addLast(stack.removeFirst() + stack.removeFirst());
          } else if (data[i].equals("-")) {
            stack.addLast(stack.removeFirst() - stack.removeFirst());
          } else if (data[i].equals("*")) {
            stack.addLast(stack.removeFirst() * stack.removeFirst());
          } else if (data[i].equals("/")) {
            stack.addLast(stack.removeFirst() / stack.removeFirst());
          } else if (data[i].equals("%")) {
            stack.addLast(stack.removeFirst() % stack.removeFirst());
          }
        }
      }
      return stack.getFirst();
    }

    public static boolean isInteger(String s) {
      try {
        Integer.parseInt(s);
      } catch (NumberFormatException e){
        return false;
      } catch (NullPointerException e) {
        return false;
      }
      return true;
    }

    public static void main(String[] args) {
      System.out.println(eval("3 5 +"));
      System.out.println(eval("3 5 + 8 *"));
      System.out.println(eval("3 5 + 8 * 4 4 + /"));
    }
}
