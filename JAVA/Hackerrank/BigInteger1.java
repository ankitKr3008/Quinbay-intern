import java.util.*;
import java.math.*;

public class BigInteger1 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s1 = new Scanner(System.in);
        BigInteger a = s1.nextBigInteger();
        BigInteger b = s1.nextBigInteger();
        System.out.println(a.add(b));
        System.out.println(a.multiply(b));
        s1.close();
    }
}
