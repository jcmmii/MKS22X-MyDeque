import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    @SuppressWarnings("unchecked")
    public static double eval(String s){
      MyDeque<Double> calculation = new MyDeque();
      String[] arr = s.split(" ");
      double ret = 0.0;
      for (int x = 0; x < arr.length; x++){
        if (checkNumber(arr[x])) {
          calculation.addLast(Double.parseDouble(arr[x]));
        } else {
          double dou1 = calculation.removeLast();
          double dou2 = calculation.removeLast();
          if (arr[x].equals("+")) ret = dou2 + dou1;
          if (arr[x].equals("-")) ret = dou2 - dou1;
          if (arr[x].equals("*")) ret = dou2 * dou1;
          if (arr[x].equals("/")) ret = dou2 / dou1;
          if (arr[x].equals("%")) ret = dou2 % dou1;
          if (ret != 0.0) calculation.addLast(ret);
          }
      }
      return ret;
    }

    private static boolean checkNumber(String str) {
      try {
        Double.parseDouble(str);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }

    public static void main(String[] args) {
      String string1 = "10 2.0 +";
      String string2 = "11 3 - 4 + 2.5 *";
      String string3 = "8 2 + 99 9 - * 2 + 9 -";
      String string4 = "1 2 3 4 5 + * - -";
      System.out.println(eval(string1) + "should be 12");
      System.out.println(eval(string2) + "should be 30");
      System.out.println(eval(string3) + "should be 893");
      System.out.println(eval(string4) + "should be 26");
    }
}
