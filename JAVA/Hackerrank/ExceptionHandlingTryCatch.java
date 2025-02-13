import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandlingTryCatch {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s1 = new Scanner(System.in);
        try{
            int x = s1.nextInt();
            int y = s1.nextInt();
            int res = x/y;
            System.out.println(res);
        }
        catch(InputMismatchException e){
            System.out.println(e.getClass().getName());
        }
        catch(Exception e){
            System.out.println(e);
        }
        s1.close();
    }
}
