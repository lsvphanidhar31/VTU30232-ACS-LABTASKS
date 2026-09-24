import java.util.*;

public class HashMapFreq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        int N = sc.nextInt();

        
        HashMap<Integer, Integer> frequency = new HashMap<>();

       
        for (int i = 0; i < N; i++) {
            int productID = sc.nextInt();

            frequency.put(productID,
                    frequency.getOrDefault(productID, 0) + 1);
        }

        int maxFrequency = 0;
        int resultProduct = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            int productID = entry.getKey();
            int count = entry.getValue();

            if (count > maxFrequency ||
                (count == maxFrequency && productID < resultProduct)) {

                maxFrequency = count;
                resultProduct = productID;
            }
        }

    
        System.out.println(resultProduct + " " + maxFrequency);

        sc.close();
    }
}
