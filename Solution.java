import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int[] coins;
        int N, M;
        long[][] dp;
        N = scanner.nextInt();
        M = scanner.nextInt();
        coins = new int[M];
        dp = new long[M][N + 1];
        for (int i = 0; i < M; i++) {
            coins[i] = scanner.nextInt();
            dp[i][0] = 1;
        }
        for (int i = 0; i < M; i++) {
            for (int sum = 1; sum <= N; sum++) {
                long left = 0;
                if (sum - coins[i] >= 0) {
                    left = dp[i][sum - coins[i]];
                }
                
                long right = 0;
                if (i - 1 >= 0) {
                    right = dp[i - 1][sum];
                }
                dp[i][sum] = left + right;
            }
        }
        
        System.out.println(dp[M - 1][N]);
    }
}