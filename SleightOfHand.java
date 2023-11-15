import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collections;
public class SleightOfHand {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<String> arr = readList(reader);
            Integer result = countPoints(n, arr);
            System.out.println(result);
        }
    }
    private static Integer countPoints(int n, List<String> arr) {
        int goalCount = n * 2;
        int result = 0;
        for (int i = 1; i < 10; i++) {
            String iStr = String.valueOf(i);
            int freq = Collections.frequency(arr, iStr);
            if (freq <= goalCount && freq != 0) {
                result += 1;
            }
        }
        return result;
    }
    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
    private static List<String> readList(BufferedReader reader) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String line = reader.readLine();
            for (char item : line.toCharArray()){
                list.add(Character.toString(item));
            }
        }
        return list;
    }
}
