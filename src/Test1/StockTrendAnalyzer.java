package Test1;
import java.util.*;

public class StockTrendAnalyzer {
    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
//        int[] arr = {10, 22, 9, 33, 21, 50 };
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxi = 1;
        int lastIndex = 0;

        for(int curr = 1; curr < n; curr++) {
            for(int prev = 0; prev < curr; prev++) {
                if(arr[curr] > arr[prev] && dp[curr] < dp[prev]+1) {
                    dp[curr] = dp[prev] + 1;
                    maxi = Math.max(maxi, dp[curr]);
                    parent[curr] = prev;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(dp[i] == maxi) {
                lastIndex = i;
                break;
            }
        }

        for(int i = lastIndex; i != -1; i = parent[i]) {
            ans.add(arr[i]);
        }

        Collections.reverse(ans);

        System.out.print(ans);
    }
}
