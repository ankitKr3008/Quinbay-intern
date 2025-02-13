import java.util.Scanner;

public class SubstringComparison {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        smallest = s.substring(0,k);
        largest = smallest;
        for(int i = 1; i+k <= s.length(); i++){
            String temp = s.substring(i,i+k);
            if(temp.compareTo(largest) > 0) largest = temp;
            if(smallest.compareTo(temp) > 0) smallest = temp;
        }
        
        return smallest + "\n" + largest;
    }

    public static void main(String[] a){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
