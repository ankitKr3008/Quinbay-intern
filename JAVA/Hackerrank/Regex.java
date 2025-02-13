import java.util.Scanner;

class MyRegex{
    String p = "(([0-1]?[0-9]?[0-9])|(2[0-4]?[0-9])|(25[0-5]))";
    String pattern= p+"."+p+"."+p+"."+p;
}

public class Regex {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            System.out.println(IP.matches(new MyRegex().pattern));
        }
        in.close();
    }
}
