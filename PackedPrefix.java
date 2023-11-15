import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PackedPrefix {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))){
            int n = Integer.parseInt(reader.readLine());
            String[] data = new String[n];
            for (int i = 0; i < n; i++) {
                String raw = reader.readLine();
                data[i] = openString(raw);
            }
            int min = data[0].length();
            for (int i = 0; i < n; i++) {
                int x = data[i].length();
                if(x < min) {
                    min = x;
                }
            }
            prefix(data, min, writer);
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public static String openString(String s){
        Stack<Integer> numbers = new Stack<>();
        Stack<List<Character>> letters = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if(Character.isAlphabetic(letter)){
                if(letters.empty()){
                    result.append(letter);
                } else {
                    letters.peek().add(letter);
                }
            } else if(Character.isDigit(letter)){
                List<Character> list = new ArrayList<>();
                numbers.add(letter - 48);
                letters.add(list);
            } else if(letter == ']'){
                int n = numbers.pop();
                List<Character> list = letters.pop();
                if(letters.empty()){
                    for (int j = 0; j < n; j++) {
                        for (char x: list) {
                            result.append(x);
                        }
                    }
                } else {
                    List<Character> list1 = letters.peek();
                    for (int j = 0; j < n; j++) {
                        list1.addAll(list);
                    }
                }
            }
        }
        return result.toString();
    }

    public static void prefix(String[] data, int min, BufferedWriter writer) throws IOException {
        for (int i = 0; i < min; i++) {
            char letter = data[0].charAt(i);
            boolean check = true;
            for (String word: data) {
                if(letter != word.charAt(i)){
                    check = false;
                    break;
                }
            }
            if(check){
                writer.write(Character.toString(letter));
            } else{
                break;
            }
        }
    }
}
