import java.util.Scanner;

public class Lops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int j = 1; j <= n; j++){
                a += Math.pow(2, j-1)*b;
                System.out.print(a + " ");
            }
            System.out.println();
        }
        in.close();
    }
    
}
