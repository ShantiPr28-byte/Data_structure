package DynamicProgramming;

import java.util.Arrays;

public class DiceCombination {
    public static void main(String[] args) {
        long dp[]=new long[4];
        Arrays.fill(dp,-1);
        long c=helper(3,0,dp);
        System.out.println(c);
    }
    public static long helper(int n,int sum,long dp[]){
        if(sum>n)return 0;
        if(sum==n)return 1;
        if(dp[sum]!=-1)return dp[sum];
        long ans=0;
        for(int i=1;i<=6;i++){
            ans=ans+helper(n,sum+i,dp);
        }
        return ans;
    }
}
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
//public class DiceCombination {
//    static final int MOD = 1000000007;
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        long[] dp = new long[n + 1];
//        dp[0] = 1;
//
//        for (int sum = 1; sum <= n; sum++) {
//            for (int i = 1; i <= 6; i++) {
//                if (sum - i >= 0) {
//                    dp[sum] = (dp[sum] + dp[sum - i]) % MOD;
//                }
//            }
//        }
//
//        System.out.println(dp[n]);
//    }
//}
//
