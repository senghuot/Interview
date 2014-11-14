import java.util.*;

public class Perm {

   public static void main(String[] args) {
      System.out.println(permutation("abc"));
   }
   
   public static List<String> permutation(String w) {
      List<String> res = new ArrayList<String>();
      
      if (w.length() == 0) {
         res.add("");
         return res;
      }
      
      char first = w.charAt(0);
      String rest = w.substring(1);
      List<String> tmp = permutation(rest);
      for (String t: tmp) {
         for (int i = 0; i <= t.length(); i++) {
            String t1 = t.substring(0, i);
            String t2 = t.substring(i);
            res.add(t1 + first + t2);
         }
      }
      return res;
   }
}