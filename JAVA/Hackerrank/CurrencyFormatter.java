import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        // Write your code here.
        NumberFormat curr1 = NumberFormat.getCurrencyInstance(Locale.US);
        String us = curr1.format(payment);
        NumberFormat curr2 = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
        String india = curr2.format(payment);
        NumberFormat curr3 = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = curr3.format(payment);
        NumberFormat curr4 = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = curr4.format(payment);
        
        
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
