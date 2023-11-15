import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
public class SameSums {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            int n = Integer.parseInt(reader.readLine());
            List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
                    .collect(Collectors.toList());
            if(partIsPossible(n, numbers)){
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private static boolean partIsPossible(int n, List<Integer> numbers){
        int sumNumbers = numbers.stream().mapToInt(Integer::intValue).sum();
        if(sumNumbers % 2 != 0){
            return false;
        }
        int median = sumNumbers / 2;
        boolean[] dp = new boolean[median + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            boolean[] currentdp = dp.clone();
            for (int j = 0; j < median + 1; j++) {
                if(currentdp[j]){
                    int next = numbers.get(i) + j;
                    if(median >= next){
                        dp[next] = true;
                    }
                }
            }
        }
        return dp[median];
    }
}
