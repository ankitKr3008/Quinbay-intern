import java.math.BigDecimal;
import java.util.*;

public class BigDecimal1 {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
      	sc.close();

        //Write your code here
        for(int i = 0; i < n; i++){
            BigDecimal maxi = new BigDecimal(s[i]);
            int index = i;
            for(int j = i+1; j < n; j++){
                BigDecimal now = new BigDecimal(s[j]);
                if(now.compareTo(maxi) == 1){
                    index = j;
                    maxi = now;
                }
            }
            String temp = s[i];
            s[i] = s[index];
            s[index] = temp;
        }

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }
}
