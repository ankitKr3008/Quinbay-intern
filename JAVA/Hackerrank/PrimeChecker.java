import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import static java.lang.System.in;
class Prime{
    public void checkPrime(int... intArgs){
        for(int i : intArgs){
            if(i == 1) continue;
            else{
                boolean check = true;
                for(int j = 2; j*j <= i; j++){
                    if(i%j == 0){
                        check = false;
                        break;
                    }
                }
                if(check) System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}

public class PrimeChecker {
    public static void main(String[] args) {
		try{
		BufferedReader br=new BufferedReader(new InputStreamReader(in));
		int n1=Integer.parseInt(br.readLine());
		int n2=Integer.parseInt(br.readLine());
		int n3=Integer.parseInt(br.readLine());
		int n4=Integer.parseInt(br.readLine());
		int n5=Integer.parseInt(br.readLine());
		Prime ob=new Prime();
		ob.checkPrime(n1);
		ob.checkPrime(n1,n2);
		ob.checkPrime(n1,n2,n3);
		ob.checkPrime(n1,n2,n3,n4,n5);	
		Method[] methods=Prime.class.getDeclaredMethods();
		Set<String> set=new HashSet<>();
		boolean overload=false;
		for(int i=0;i<methods.length;i++)
		{
			if(set.contains(methods[i].getName()))
			{
				overload=true;
				break;
			}
			set.add(methods[i].getName());
			
		}
		if(overload)
		{
			throw new Exception("Overloading not allowed");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
