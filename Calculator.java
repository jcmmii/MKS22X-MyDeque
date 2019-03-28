import java.util.*;

public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    @SuppressWarnings("unchecked")
    public static double eval(String s){
      MyDeque<Double> calculation = new MyDeque();
      String[] arr = s.split(" ");
    //  System.out.println(Arrays.toString(arr));
      double ret = 0.0;
      for (int x = 0; x < arr.length; x++){
        if (checkNumber(arr[x])) {
          calculation.addLast(Double.parseDouble(arr[x]));
      //    System.out.println(calculation.size());
      //    System.out.println(calculation);
        } else {
          double dou1 = calculation.removeLast();
          double dou2 = calculation.removeLast();
      //    System.out.println(calculation);
          if (arr[x].equals("+")) ret = dou2 + dou1;
          if (arr[x].equals("-")) ret = dou2 - dou1;
          if (arr[x].equals("*")) ret = dou2 * dou1;
          if (arr[x].equals("/")) ret = dou2 / dou1;
          if (arr[x].equals("%")) ret = dou2 % dou1;
          if (ret != 0.0) calculation.addLast(ret);
      //    System.out.println(calculation);
          }
      }
      return ret;
    }

/*
      MyDeque<String> calculation = new MyDeque();
      MyDeque<String> operations = new MyDeque();
      MyDeque<String> values = new MyDeque();
      for (int x = 0; x < s.length(); x++) {
        if (s.charAt(x) != ' ') {
          boolean spaceCheck = true;
          int n = 1;
          String hold = "";
          while (spaceCheck) {
            if (s.charAt(x+n-1)!=' ' && x+n < s.length()) {
              n++;
            }
            else {
              hold = "" + s.substring(x,x+n);
              spaceCheck = false;
              x = x + n;
              n=1;
            }
          }
          if (checkNumber(hold)) {
            values.addLast(hold);
          } else {
            operations.addLast(hold);
          }
        }
      }

*/
 /*
        if (values.size() >= 2 && operations.size() >= 1) {
          String op = operations.removeFirst();
          int firstVal = Integer.parseInt(values.removeFirst());
          int secVal = Integer.parseInt(values.removeFirst());
          int goback;
          if (op == "+") goback = firstVal + secVal;
          if (op == "-") goback = firstVal - secVal;
          if (op == "*") goback = firstVal * secVal;
          if (op == "/") goback = firstVal / secVal;
          if (op == "%") goback = firstVal & secVal;
          String gobackStr = goback + "";
          values.addFirst(gobackStr);
        }

      }
*/

      private static boolean checkNumber(String str) {
        try {
          Double.parseDouble(str);
          return true;
        } catch (NumberFormatException e) {
          return false;
        }
      }



/*
      MyDeque<Integer> test = new MyDeque();
      for (int i = 0; i < s.length(); i++) {
        String sub = s.substring(i,i+1);
        if (!sub.equals(" ")) test.addLast(Integer.parseInt(sub));
      }
      System.out.println(test);
      return 0.0; //PLACEHOLDER
    }
    */

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



//one MyDeque
//encounter number add to mydeu
//take last two numbers for MyDeque
//do operation //put back
