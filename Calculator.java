public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    @SuppressWarnings("unchecked")
    public static double eval(String s){
      MyDeque<String> calculation = new MyDeque();
      MyDeque<String> operations = new MyDeque();
      MyDeque<String> values = new MyDeque();
      for (int x = 0; x < s.length(); x++) {
        if (s.charAt(x) != ' ') {
          boolean spaceCheck = false;
          int n = 0;
          String hold = "";
          while (!spaceCheck) {
            if (s.charAt(x+n)!=' ' && x+n < s.length()) {
              n++;
            }
            else {
              hold = "" + s.substring(x,x+n);
              spaceCheck = true;
              n=0;
            }
          }
          if (checkNumber(hold)) {
            values.addLast(hold);
          } else {
            operations.addLast(hold);
          }
        }
      }

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
    System.out.println(values);
    System.out.println(operations);
    return 0.0;


}
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
      String string1 = "11 3 - 4 + 2.5 *";
      eval(string1);
    }


}
