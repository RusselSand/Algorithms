import java.io.*;

public class LevenshteinDistance {
    public static void main(String[] args){
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String first = reader.readLine();
            String second = reader.readLine();
            int result = getLevenstain(second, first);
            System.out.println(result);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private static int getLevenstain(String first, String second){
        int[][] dp = new int[2][second.length() + 1];
        for (int i = 0; i <= second.length() ; i++) {
            dp[0][i] = i;
        }
        int current = 1;
        int old = 0;
        for (int i = 0; i < first.length(); i++) {
            current = i % 2 == 0 ? 1 : 0;
            old = i % 2 == 0 ? 0 : 1;
            dp[current][0] = i + 1;
            for (int j = 1; j <= second.length(); j++) {
                if(first.charAt(i) != second.charAt(j-1)){
                    dp[current][j] = Integer.min(Integer.min(dp[current][j-1] + 1, dp[old][j-1] + 1), dp[old][j] + 1);
                } else {
                    dp[current][j] = Integer.min(Integer.min(dp[current][j-1] + 1, dp[old][j-1]), dp[old][j] + 1);
                }
            }
        }
        return dp[current][second.length()];
    }
}
