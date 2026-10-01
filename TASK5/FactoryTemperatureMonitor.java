import java.util.*;

public class FactoryTemperatureMonitor{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] temp = new int[n];
        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            temp[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temp[i] > temp[stack.peek()]) {
                result[stack.pop()] = temp[i];
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]);

            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        sc.close();
    }
}
