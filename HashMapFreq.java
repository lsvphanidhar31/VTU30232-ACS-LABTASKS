import java.util.*;

public class HashMapFreq {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Integer> freq = new HashMap<>();

       
        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            freq.put(id, freq.getOrDefault(id, 0) + 1);
        }

        int maxFreq = 0;
        int answer = Integer.MAX_VALUE;

      
        // If frequencies are equal, choose smaller ID
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {

            int id = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                answer = id;
            }
            else if (count == maxFreq && id < answer) {
                answer = id;
            }
        }

        System.out.println(answer + " " + maxFreq);

        sc.close();
    }
}