package tedu.day1;
 
import java.util.Scanner;
 
import tedu.day1301.Formula.DieDaiQi;
 
public class For {
   public static void main(String[] args) {
      System.out.println("输入算式：");
      String s = new Scanner(System.in).nextLine();
     
      Formula f = new Formula(s);
      DieDaiQi d = f.diedaiqi();
      while(d.hasNext()) {
         String s2 = d.next();
         System.out.println(s2);
      }
     
      double r = f.eval();
      System.out.println(r);
   }
}
