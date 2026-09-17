import java.util.Scanner;

public class TrafficSignalCongestionAnalyzer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of traffic signals: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("\nEnter number of vehicles at Signal " + i + ": ");
            int vehicles = sc.nextInt();

            System.out.print("Enter waiting time in minutes: ");
            int waitingTime = sc.nextInt();

            String congestionLevel;

            if (vehicles <= 20 && waitingTime <= 5) {
                congestionLevel = "LOW";
            } 
            else if (vehicles <= 50 && waitingTime <= 10) {
                congestionLevel = "MEDIUM";
            } 
            else {
                congestionLevel = "HIGH";
            }

            System.out.println("Signal " + i);
            System.out.println("Vehicles      : " + vehicles);
            System.out.println("Waiting Time  : " + waitingTime + " minutes");
            System.out.println("Congestion    : " + congestionLevel);

            if (congestionLevel.equals("HIGH")) {
                System.out.println("Action        : Increase green signal time");
            } 
            else if (congestionLevel.equals("MEDIUM")) {
                System.out.println("Action        : Monitor traffic");
            } 
            else {
                System.out.println("Action        : Normal signal timing");
            }
        }

        sc.close();
    }
}