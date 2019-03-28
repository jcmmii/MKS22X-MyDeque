import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    @SuppressWarnings("unchecked") //suppresses warnings
    public static double eval(String s){
      MyDeque<Double> calculation = new MyDeque();
      String[] arr = s.split(" "); //array created, separated by spaces off String s
      double ret = 0.0; //assigned default val
      for (int x = 0; x < arr.length; x++){
        if (checkNumber(arr[x])) { //checks if it is a number
          calculation.addLast(Double.parseDouble(arr[x]));
        } else { //it is an operation
          //removes the last two numbers of the Deque, does operation left to right, adds back
          double dou1 = calculation.removeLast();
          double dou2 = calculation.removeLast();
          if (arr[x].equals("+")) ret = dou2 + dou1;
          if (arr[x].equals("-")) ret = dou2 - dou1;
          if (arr[x].equals("*")) ret = dou2 * dou1;
          if (arr[x].equals("/")) ret = dou2 / dou1;
          if (arr[x].equals("%")) ret = dou2 % dou1;
          calculation.addLast(ret);
          }
      }
      //once the loop through the array is finished, returns the value
      return ret;
    }

    //helper method testing if String str is a number or not
    private static boolean checkNumber(String str) {
      try {
        Double.parseDouble(str);
        return true;
      } catch (NumberFormatException e) {
        return false;
      }
    }

    //test cases
    /*
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
    */
}
