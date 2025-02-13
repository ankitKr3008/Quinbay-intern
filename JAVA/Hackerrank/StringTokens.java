import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();
        // Write your code here.
        s = s.trim();
        if(s.length() == 0){
            System.out.println(0);
            return;
        }
        // String str[] = s.split("[, !?._'@]+");
        String str[] = s.split("[ !,?._'@]+");
        System.out.println(str.length);
        if(str.length != 0){
            for(String e : str){
                System.out.println(e);
            } 
        }
    }
}
