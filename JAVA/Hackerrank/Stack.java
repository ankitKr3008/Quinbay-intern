import java.util.Scanner;

public class Stack {
    public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.next();
            //Complete the code
            Stack <Character>s1 = new Stack ();
            boolean ans = true;
            for(int i = 0 ;i < input.length(); i++){
                if(input.charAt(i) == '{' || input.charAt(i) == '(' || input.charAt(i) == '['){
                    s1.push(input.charAt(i));
                }
                else{
                    if((s1.empty()) || (input.charAt(i) == '}' && s1.pop() != '{') || (input.charAt(i) == ']' && s1.pop() != '[') || (input.charAt(i) == ')' && s1.pop() != '(')){
                        ans = false;
                    }
                }
            }
            if(!s1.empty()) ans = false;
            if(ans) System.out.println("true");
            else System.out.println("false");
            
		}
		sc.close();
	}
}
