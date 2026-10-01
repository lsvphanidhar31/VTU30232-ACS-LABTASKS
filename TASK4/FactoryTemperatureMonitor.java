import java.util.*;

public class  FactoryTemperatureMonitor{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{' || ch == '<') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}' || ch == '>') {

                if (stack.isEmpty()) {
                    System.out.println("INVALID");
                    return;
                }

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == ']' && top != '[') ||
                    (ch == '}' && top != '{') ||
                    (ch == '>' && top != '<')) {
                    System.out.println("INVALID");
                    return;
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("VALID");
        } else {
            System.out.println("INVALID");
        }

        sc.close();
    }
}
