import java.util.*;

public class CircularDeliveryRouteRepair {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createList(int[] values, int cyclePosition) {
        if (values.length == 0) {
            return null;
        }

        Node head = new Node(values[0]);
        Node current = head;
        Node cycleNode = cyclePosition == 0 ? head : null;

        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;

            if (i == cyclePosition) {
                cycleNode = current;
            }
        }

        if (cyclePosition != -1) {
            current.next = cycleNode;
        }

        return head;
    }

    static void removeCycle(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slow = head;
        Node fast = head;
        boolean found = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                found = true;
                break;
            }
        }

        if (!found) {
            return;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        Node cycleStart = slow;
        Node current = cycleStart;

        while (current.next != cycleStart) {
            current = current.next;
        }

        current.next = null;
    }

    static Node reverseKGroup(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        while (current != null && count < k) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
            count++;
        }

        head.next = reverseKGroup(current, k);

        return previous;
    }

    static void printList(Node head) {
        Node current = head;

        while (current != null) {
            System.out.print(current.data);

            if (current.next != null) {
                System.out.print(" ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int cyclePosition = sc.nextInt();

        Node head = createList(values, cyclePosition);

        removeCycle(head);

        head = reverseKGroup(head, k);

        printList(head);

        sc.close();
    }
}
