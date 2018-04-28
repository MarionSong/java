package day1;
 
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class Formula {
   private String f;
   public Formula(String f) {
      this.f = f.trim();
   }
  
  
   public DieDaiQi diedaiqi() {
      return new DieDaiQi();
   }
  
  
   public class DieDaiQi {
      int from;
      Matcher m =
       Pattern
       .compile("\\d+(\\.\\d+)?|[+\\-*/]")
       .matcher(f);
     
      public boolean hasNext() {
         return from < f.length();
      }
      public String next() {
         m.find(from);
         String s = m.group();
         from = m.end();
         return s;
      }
   }
  
  
  
   public double eval() {
      //<> 泛型不支持基本类型
      LinkedList<Double> list1 = new LinkedList<>();
      LinkedList<Character> list2 = new LinkedList<>();
      DieDaiQi d = diedaiqi();
      while(d.hasNext()) {
         String s = d.next();
         if(s.matches("\\d+(\\.\\d+)?")) {//s是数字
            list1.add(Double.parseDouble(s));
         } else if(s.matches("[+\\-]")) {//s是加减
            list2.add(s.charAt(0));
         } else {//s是乘除
            double a = list1.removeLast();
            double b = Double.parseDouble(d.next());
            double c = jiSuan(a, s.charAt(0), b);
            list1.add(c);
         }
      }
     
      //加减运算
      while(list2.size()!=0) {
         double a = list1.removeFirst();
         double b = list1.removeFirst();
         char op = list2.removeFirst();
         double c = jiSuan(a, op, b);
         list1.addFirst(c);
      }
     
      return list1.get(0);
   }
 
 
   private double jiSuan(double a, char op, double b) {
      double r=0;
      switch(op) {
      case '+': r=a+b; break;
      case '-': r=a-b; break;
      case '*': r=a*b; break;
      case '/': r=a/b; break;
      }
      return r;
   }
  
  
}
 
 
 