import java.util.*;

public class Main IntelligentCpuTaskSchedular{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] frequency = new int[26];

        for (int i = 0; i < n; i++) {
            char task = sc.next().charAt(0);
            frequency[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int freq : frequency) {
            if (freq > 0) {
                maxHeap.offer(freq);
            }
        }

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {

            time++;

            if (!maxHeap.isEmpty()) {
                int remaining = maxHeap.poll() - 1;

                if (remaining > 0) {
                    cooldown.offer(new int[]{remaining, time + k});
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }

            if (maxHeap.isEmpty() && !cooldown.isEmpty()) {
                time = cooldown.peek()[1] - 1;
            }
        }

        System.out.println(time);

        sc.close();
    }
}
