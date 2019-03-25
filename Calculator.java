import java.util.*;
public class Calculator{
  /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      String[] data = s.split(" ");
      MyDeque<Double> stack = new MyDeque<Double>();
      double result = 0;
      for (int i = 0; i < data.length; i++) {
        if (isInteger(data[i])) {
          stack.addFirst(Double.valueOf(data[i]));
        } else {
          if (data[i].equals("+")) {
            result = stack.removeFirst() + stack.removeFirst();
          } else if (data[i].equals("-")) {
            result = stack.removeFirst() - stack.removeFirst();
          } else if (data[i].equals("*")) {
            result = stack.removeFirst() * stack.removeFirst();
          } else if (data[i].equals("/")) {
            result = stack.removeFirst() / stack.removeFirst();
          } else if (data[i].equals("%")) {
            result = stack.removeFirst() % stack.removeFirst();
          }
        }
      }



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
}
