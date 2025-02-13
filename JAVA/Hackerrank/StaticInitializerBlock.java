import java.util.Scanner;

    public class StaticInitializerBlock {
    private static int B,H;
    private static boolean flag;

    static{
        Scanner s1 = new Scanner(System.in);
        
        B = s1.nextInt();
        H = s1.nextInt();
        
        if(B > 0 && H > 0){
            flag = true;
        }
        else {
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
        s1.close();
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }
    } 
}
