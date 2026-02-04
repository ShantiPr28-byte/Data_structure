package DynamicProgramming;

import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int result = fibbSo(n);
        System.out.println(result);
    }

    //memoization
    private static int fibo(int n, int[] dp) {
        if(n<=1) {
            return n;
        }
        if(dp[n] != -1) {
            return dp[n];
        }
        return dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
    }

    //Bottom up(tabulation)
    private static int fibbT(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i =2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    //space optimization
    private static int fibbSo(int n) {
        int prev_2 = 0;
        int prev_1 = 1;
        for(int i=2; i<=n; i++) {
            int curr = prev_1 + prev_2;
            prev_2 = prev_1;
            prev_1 = curr;
        }
        return prev_1;
    }
}
