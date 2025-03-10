import java.io.*;
import java.util.*;
interface PerformOperation {
 boolean check(int a);
}
class MyMath {
 public static boolean checker(PerformOperation p, int num) {
  return p.check(num);
 }
  public PerformOperation isOdd() {
        // return (a) -> a % 2 != 0;
        return (a) -> (a % 2 == 1);
    }

    public PerformOperation isPrime() {
        return (a) -> java.math.BigInteger.valueOf(a).isProbablePrime(1);
    }

    public PerformOperation isPalindrome() {
        return (a) -> Integer.toString(a).equals(new StringBuilder(Integer.toString(a)).reverse().toString());
    }

}
public class LambdaExpression {

 public static void main(String[] args) throws IOException {
  MyMath ob = new MyMath();
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int T = Integer.parseInt(br.readLine());
  PerformOperation op;
  String ans = null;
  while (T--> 0) {
   String s = br.readLine().trim();
   StringTokenizer st = new StringTokenizer(s);
   int ch = Integer.parseInt(st.nextToken());
   int num = Integer.parseInt(st.nextToken());
   if (ch == 1) {
    op = ob.isOdd();
    ans = (MyMath.checker(op, num)) ? "ODD" : "EVEN";
   } else if (ch == 2) {
    op = ob.isPrime();
    ans = (MyMath.checker(op, num)) ? "PRIME" : "COMPOSITE";
   } else if (ch == 3) {
    op = ob.isPalindrome();
    ans = (MyMath.checker(op, num)) ? "PALINDROME" : "NOT PALINDROME";

   }
   System.out.println(ans);
  }
 }
}

