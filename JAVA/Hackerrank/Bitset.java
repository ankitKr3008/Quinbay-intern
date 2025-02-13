import java.util.BitSet;
import java.util.Scanner;

public class Bitset {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        BitSet b1 = new BitSet(n1);
        BitSet b2 = new BitSet(n1);
        for(int i = 0; i < n2; i++){
            String s1 = sc.next();
            int first = sc.nextInt();
            int second = sc.nextInt();
            if(s1.equals("AND")){
                if(first == 1){
                    b1.and(b2);
                }
                else{
                    b2.and(b1);
                }
            }
            else if(s1.equals("OR")){
                if(first == 1){
                    b1.or(b2);
                }
                else{
                    b2.or(b1);
                }
            }
            else if(s1.equals("XOR")){
                if(first == 1){
                    b1.xor(b2);
                }
                else{
                    b2.xor(b1);
                }
            }
            else if(s1.equals("FLIP")){
                if(first == 1){
                    b1.flip(second);
                }
                else{
                    b2.flip(second);
                }
            }
            else {
                if(first == 1){
                    b1.set(second);
                }
                else{
                    b2.set(second);
                }
            }
            System.out.println(b1.cardinality() + " " + b2.cardinality());
        }
        sc.close();
    }
}
