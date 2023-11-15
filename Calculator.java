import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Stack;
public class Calculator {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            String line = reader.readLine();
            String[] ch = line.split(" ");
            System.out.println(polish_calc(ch));
        }
    }
    private static Integer polish_calc(String[] dataArray) {
        Stack<Integer> stack = new Stack<>();
        for (String el : dataArray) {
            switch (el) {
                case "-":
                    int second = stack.pop();
                    stack.push(stack.pop() - second);
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int second1 = stack.pop();
                    int result = Math.floorDiv(stack.pop(), second1);
                    stack.push(result);
                    break;
                default:
                    stack.push(Integer.parseInt(el));
                    break;
            }
        }
        return stack.pop();
    }
}
