import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class PrimalityTest {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String n = bufferedReader.readLine();
        BigInteger n1 = new BigInteger(n);
        if(n1.isProbablePrime(1)){
            System.out.println("prime");
        }
        else System.out.println("not prime");
    

        bufferedReader.close();
    }
}
