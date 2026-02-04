package Recursion;

//public class coincombination {
//    public static void main(String[] args) {
//        int coins[]=new int[]{2,3,5};
//        int target=9;
//        Integer dp[]=new Integer[target+1];
//        System.out.println(helper(coins,target,dp));
//    }
//    public static int helper(int coins[],int target,Integer dp[]){
//        if(target==0)return 1;
//
//        if(target<0 )return 0;
//        if(dp[target]!=null) return dp[target];
//        int ans=0;
//        for(int j=0;j<coins.length;j++){
//               ans=ans+helper(coins,target-coins[j],dp);
//        }
//        return ans;
//    }
//}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coincombination {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int sum = 1; sum <= target; sum++) {
            for (int coin : coins) {
                if (sum - coin >= 0) {
                    dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
                }
            }
        }

        System.out.println(dp[target]);
    }
}
