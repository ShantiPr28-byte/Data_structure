package Test1;
import java.util.*;

public class ChronologicalLibrarian {
    public static void main(String[] args) {
//        int[] arr = {10, 9, 2, 5, 3, 7};
//        int[] arr = {0, 1, 0, 3, 2, 3};
        int[] arr = {7, 7, 7, 7, 7};
        int n = arr.length;

        Integer[][] dp = new Integer[n][n+1];
        int ans = solve(arr, 0, -1, dp);
        System.out.println(ans);
    }
    public static int solve(int[] arr, int idx, int prev, Integer[][] dp) {
        if(idx == arr.length) return 0;

        if(dp[idx][prev+1] != null) {
            return dp[idx][prev+1];
        }

        int skip = solve(arr, idx+1, prev, dp);
        int take = 0;
        if(prev == -1 || arr[prev] < arr[idx]) {
            take = 1 + solve(arr, idx+1, idx, dp);
        }

        return dp[idx][prev+1] = Math.max(skip, take);
    }
}

//Time complexity = O(n^2)
//space complexity = O(n^2)
