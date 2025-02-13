import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s1 = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> l = new ArrayList<>();
        int n = s1.nextInt();
        for(int i = 0; i < n; i++){
            int m = s1.nextInt();
            ArrayList<Integer> l1 = new ArrayList<>();
            for(int j = 0; j < m; j++){
                l1.add(s1.nextInt());
            }
            l.add(l1);
        }
        int q = s1.nextInt();
        while(q-- != 0){
            int x = s1.nextInt();
            int y = s1.nextInt();
            if(x <= l.size() && y <= l.get(x-1).size()){
                System.out.println(l.get(x-1).get(y-1));
            }
            else System.out.println("ERROR!");
        }
        s1.close();
    }
}
