import java.util.Scanner;

public class EndOfFile {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner S1 = new Scanner(System.in);
        int i = 1;
        while(S1.hasNext()){
            String s = S1.nextLine();
            System.out.println(i + " " + s);
            i++;
        }
        S1.close();
    }
}
