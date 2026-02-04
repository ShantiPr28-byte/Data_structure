package DynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};
        int capacity = 7;
        int n = wt.length;

//        int ans = recursion(wt, val, capacity, n);
//        System.out.println(ans);

//        Integer[][] dp = new Integer[n][capacity+1];
//        int ans = memoization(wt, val, capacity, n-1, dp);
//        System.out.println(ans);

        int ans = tabulation(wt, val, capacity);
        System.out.println(ans);
    }

    //count based n
    public static int recursion(int[] wt, int[]val, int W, int n) {
        if(n == 0 || W == 0) return 0;

        if(wt[n-1] <= W) {
            return Math.max(val[n-1] + recursion(wt, val, W - wt[n-1], n-1), recursion(wt, val, W, n-1));
        } else {
            return recursion(wt, val, W, n-1);
        }
    }

    //index based n
    public static int memoization(int[] wt, int[] val, int W, int n, Integer[][] dp) {
        if(n < 0 || W == 0) return 0;

        if(dp[n][W] != null) return dp[n][W];

        if(wt[n] <= W) {
            dp[n][W] = Math.max(val[n] + memoization(wt, val, W-wt[n], n-1, dp), memoization(wt, val, W, n-1, dp));
        } else {
            dp[n][W] = memoization(wt, val, W, n-1, dp);
        }
        return dp[n][W];
    }

    public static int tabulation(int[] wt, int[] val, int W) {
        int n = wt.length;
        int[][] dp = new int[n+1][W+1];

        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= W; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(wt[i-1] <= j) {
                    dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][W];
    }
}
