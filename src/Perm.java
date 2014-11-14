import java.util.*;

public class Perm {

   public static void main(String[] args) {
      List<Integer> l = new ArrayList<Integer>();
      l.add(1);
      l.add(2);
      l.add(3);
      System.out.println(subSet(l));
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
   
   public static List<List<Integer>> subSet(List<Integer> s) {
   
      List<List<Integer>> res = new ArrayList<List<Integer>>();
      // empty base case
      if (s.isEmpty()) {
         List<Integer> tmp = new ArrayList<Integer>();
         res.add(tmp);
         return res;
      }
      
      int first = s.get(0);
      s.remove(0);
      List<List<Integer>> tmp = subSet(s);
      
      for (List<Integer> l: tmp) {
         List<Integer> a = new ArrayList<Integer>(l);
         res.add(a);
         l.add(first);
         res.add(l);  
      }
   
      return res;
      
   }
}