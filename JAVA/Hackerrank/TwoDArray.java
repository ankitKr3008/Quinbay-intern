import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TwoDArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        int sum = -100;
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 5; j++){
                int tempsum = 0;
                tempsum += arr.get(i).get(j-1);
                tempsum += arr.get(i).get(j);
                tempsum += arr.get(i).get(j+1);
                tempsum += arr.get(i+1).get(j);
                tempsum += arr.get(i+2).get(j-1);
                tempsum += arr.get(i+2).get(j);
                tempsum += arr.get(i+2).get(j+1);
                sum = Math.max(sum,tempsum);
            }
            
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
