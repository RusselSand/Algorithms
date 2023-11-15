import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class NearestNull {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            int n = readInt(reader);
            List<Integer> arr = readList(reader);
            List<Integer> result = findZero(n, arr);
            for (int el : result) {
                writer.write(el + " ");
            }
        }
    }
    private static List<Integer> findZero(int n, List<Integer> arr) {
        int zeroInd = -1;
        int zeroIndRev = -1;
        for (int i=0; i < n; i++) {
            if (arr.get(i) == 0) {
                zeroInd = i;
            }
            else {
                if (zeroInd == -1) {
                    arr.set(i, -1);
                }
                else {
                    arr.set(i, i - zeroInd);
                }
            }
        }
        for (int i=n-1; i>=0; i--) {
            if (arr.get(i) == 0) {
                zeroIndRev = i;
            }
            else {
                if (((arr.get(i) > zeroIndRev-i) && zeroIndRev != -1) || (arr.get(i) == -1)){
                    arr.set(i, zeroIndRev - i);
                }
            }
        }
        return arr;
    }

    private static int readInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }
    private static List<Integer> readList(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
