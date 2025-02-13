import java.util.Scanner;

class MoreThanOneDigitException extends Exception {
    public MoreThanOneDigitException(String message) {
        super(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        try {
            int num = s1.nextInt();
            checkSingleDigit(num);
        } catch (MoreThanOneDigitException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
        s1.close();
    }

    public static void checkSingleDigit(int num) throws MoreThanOneDigitException {
        if (num >= 10 || num <= -10) {
            throw new MoreThanOneDigitException("The number has more than one digit.");
        } else {
            System.out.println("The number is a single digit.");
        }
    }
}
