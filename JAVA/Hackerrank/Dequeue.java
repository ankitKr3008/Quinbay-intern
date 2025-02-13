import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Dequeue {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            Deque<Integer> deque = new ArrayDeque<Integer>();
            int n = in.nextInt();
            int m = in.nextInt();
            int maxi = Integer.MIN_VALUE;
            Set<Integer> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                deque.add(num);
                s.add(num);
                if (deque.size() == m) {
                    if (s.size() > maxi) {
                        maxi = s.size();
                    }
                    int first = deque.remove();
                    if (!deque.contains(first)) s.remove(first);
                }
            }
            System.out.println(maxi);
            in.close();
        }
}
