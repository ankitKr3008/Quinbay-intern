import java.util.HashSet;
import java.util.Scanner;

public class Hashset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        // for(int i= 0; i < 19; i++){
        //     System.out.println(pair_left[i] + " " + pair_right[i]);
        // }

//Write your code here
        
        HashSet<String> myhash = new HashSet<String>();
        for (int i = 0; i < t; i++) {
            myhash.add(pair_left[i]+" "+pair_right[i]);
            System.out.println(myhash.size());
        }
        s.close();
    }
}
