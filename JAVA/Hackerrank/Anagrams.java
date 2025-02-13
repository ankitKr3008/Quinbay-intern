import java.util.Scanner;

public class Anagrams {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        int arr1[] = new int[26];
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) >= 65 && a.charAt(i) <= 90)
            arr1[a.charAt(i)-65]++;
            else arr1[a.charAt(i)-97]++;
        }
        for(int i = 0; i < b.length(); i++){
            if(b.charAt(i) >= 65 && b.charAt(i) <= 90)
            arr1[b.charAt(i)-65]--;
            else arr1[b.charAt(i)-97]--;
        }
        boolean ans = true;
        for(int i = 0; i < 26; i++){
            if(arr1[i] != 0){
                ans = false;
                break;
            }
        }
        return ans;
        // return true;
        
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
