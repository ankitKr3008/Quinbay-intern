import java.util.ArrayList;
import java.util.Scanner;

public class List {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l = new ArrayList<Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n ; i++){
            l.add(sc.nextInt());
        }
        int q = sc.nextInt();
        sc.nextLine();
        while(q-- != 0){
            String op = sc.nextLine();
            if(op.equals("Insert")){
                l.add(sc.nextInt(), sc.nextInt());
            }
            else if(op.equals("Delete")){
                l.remove(sc.nextInt());
            }
            if(q!=0)sc.nextLine();
        }
        for(int j = 0; j < l.size(); j++){
            System.out.print(l.get(j) + " ");
        }
        System.out.println();
        sc.close();
    }
}
