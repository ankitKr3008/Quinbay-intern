import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        boolean ans = true;
        int i = 0, j = A.length()-1;
        while(i < j){
            if(A.charAt(i) != A.charAt(j)){
                ans = false;
                break;
            }
            i++;
            j--;
        }
        if(ans) System.out.println("Yes");
        else System.out.println("No");
        sc.close();
    }
}
